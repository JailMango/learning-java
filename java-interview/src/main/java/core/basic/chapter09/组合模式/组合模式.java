package core.basic.chapter09.组合模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 组合模式
 *
 * @author jailmango
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.组合模式
 * @since R9.0
 */
@Slf4j
public class 组合模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        nodeA.add(nodeB);

        log.info("{}", nodeA);
    }
}
