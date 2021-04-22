package com.jailmango.zk.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import lombok.extern.slf4j.Slf4j;

/**
 * Client
 *
 * @author gang.he2
 * @see com.jailmango.zk.curator
 */
@Slf4j
public class CuratorClient {

    private static final String ZK_SERVER = "127.0.0.1:2181";

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws Exception {
        // 客户端连接zk
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(5000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_SERVER, retryPolicy);
        client.start();
        log.info("zk client start successfully...");

        String rootPath = "/";
        String data1 = "node-data1";
        String data2 = "node-data-1-modify";
        String path1 = "/zktest/path1";
        String path2 = "/path2";

        // 创建节点
        // 重复创建已有的节点会失败，抛出异常[org.apache.zookeeper.KeeperException$NodeExistsException: KeeperErrorCode = NodeExists for
        // /zktest/path1]
        client.create().creatingParentsIfNeeded().forPath(path1, data1.getBytes());
        print("create", path1, data1);

        // 获取根节点下一级目录，相当于 ls /
        // List<String> result = client.getChildren().forPath(rootPath);
        print("ls", "/");
        print(client.getChildren().forPath(rootPath));

        // 获取节点值
        // byte[] result =client.getData().forPath(path1);
        print("get", path1);
        print(client.getData().forPath(path1));

        // 修改节点值
        print("set", path1, data2);
        client.setData().forPath(path1, data2.getBytes());
        print("get", path1);
        print(client.getData().forPath(path1));

        // 删除节点
        print("delete", path1);
        client.delete().forPath(path1);
        // 由于节点已经被删除，抛出异常[org.apache.zookeeper.KeeperException$NoNodeException: KeeperErrorCode = NoNode for /zktest/path1]
        // print("get", path1);
        // print(client.getData().forPath(path1));

        log.info("end...");

    }

    private static void print(String... commands) {
        StringBuilder msg = new StringBuilder("$mango: ");
        for (String command : commands) {
            msg.append(command).append(" ");
        }

        log.info("{}", msg);
    }

    private static void print(Object obj) {
        log.info("{}", obj instanceof byte[] ? new String((byte[]) obj) : obj);
    }
}
