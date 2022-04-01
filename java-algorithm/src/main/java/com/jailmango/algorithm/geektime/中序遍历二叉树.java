package com.jailmango.algorithm.geektime;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 中序遍历二叉树
 *
 * @author jailmango
 * @CreateDate 2020/9/23
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 中序遍历二叉树 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_plus = new TreeNode(-1, node_2, node_3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode root = new TreeNode(-2, node_plus, node_4);

        List<Integer> list = inorderTraversal(root);

        log.info("end...");
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode tmpNode = null;
        TreeNode curNode = root;

        while (curNode != null) {
            if (curNode.right != null) {
                stack.push(curNode.right);
                curNode.right = null;
            }

            if (curNode.left != null) {
                tmpNode = curNode.left;
                curNode.left = null;
                stack.push(curNode);
                curNode = tmpNode;
            }
            else {
                list.add(curNode.val);
                curNode = stack.peek();

                if (curNode != null) {
                    stack.removeFirst();
                }
            }
        }

        return list;
    }

    private static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
