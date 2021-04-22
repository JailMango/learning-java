package com.jailmango.zk.curator;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.CreateMode;

import lombok.extern.slf4j.Slf4j;

/**
 * CuratorPathWatch
 *
 * @author gang.he2
 * @see com.jailmango.zk.curator
 */
@Slf4j
public class CuratorCacheCase {

    private static final String ZK_SERVER = "127.0.0.1:2181";

    private static final String PATH = "/zktest";

    private static final int END = 100;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws Exception {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        // 连接zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_SERVER, new ExponentialBackoffRetry(1000, 3));
        client.start();

        log.info("zk client start successfully...");
        /**
         * Curator提供了三种Watcher(Cache)来监听结点的变化：<br>
         * Path Cache：监视一个路径下1）孩子结点的创建、2）删除，3）以及结点数据的更新。产生的事件会传递给注册的PathChildrenCacheListener。<br/>
         * Node Cache：监视一个结点的创建、更新、删除，并将结点的数据缓存在本地。<br/>
         * Tree Cache：Path Cache和Node Cache的“合体”，监视路径下的创建、更新、删除事件，并缓存路径下所有孩子结点的数据。<br/>
         */

        CuratorCache cache = CuratorCache.build(client, PATH);
        CuratorCacheListener listeners = CuratorCacheListener.builder()
            .forCreates(node -> log.info("Node created... [{}:{}]", node.getPath(), new String(node.getData())))
            .forChanges((oldNode, newNode) -> log.info("Node changed... [{}:{}] -> [{}:{}]", oldNode.getPath(),
                new String(oldNode.getData()), newNode.getPath(), new String(newNode.getData())))
            .forDeletes(node -> log.info("Node deleted... [{}:{}]", node.getPath(), new String(node.getData())))
            .forCreatesAndChanges((oldNode, newNode) -> {
                log.info("Node created or changed...");

                Optional<ChildData> oldOptional = Optional.ofNullable(oldNode);
                Optional<ChildData> newOptional = Optional.ofNullable(newNode);

                oldOptional.ifPresent(node -> log.info("Old[{}:{}]...", node.getPath(), new String(node.getData())));
                newOptional.ifPresent(node -> log.info("New[{}:{}]...", node.getPath(), new String(node.getData())));
            }).forAll((type, oldNode, newNode) -> log.info("All... Event[{}]", type.name())).build();

        cache.listenable().addListener(listeners);
        cache.start();

        client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("");

        int count = 0;
        while (count <= END) {
            Thread.sleep(1000);
        }

        CloseableUtils.closeQuietly(cache);
        CloseableUtils.closeQuietly(client);

        // // now randomly create/change/delete nodes
        // for (int i = 0; i < 1000; ++i) {
        // int depth = random.nextInt(1, 4);
        // String path = makeRandomPath(random, depth);
        // if (random.nextBoolean()) {
        // client.create().orSetData().creatingParentsIfNeeded().forPath(path, Long.toString(random.nextLong()).getBytes());
        // }
        // else {
        // client.delete().quietly().deletingChildrenIfNeeded().forPath(path);
        // }
        //
        // Thread.sleep(5);
        // }
    }

    private static String makeRandomPath(ThreadLocalRandom random, int depth) {
        if (depth == 0) {
            return PATH;
        }

        return makeRandomPath(random, depth - 1) + "/" + random.nextInt(3);
    }
}
