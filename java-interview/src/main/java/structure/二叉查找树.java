package structure;

import lombok.extern.slf4j.Slf4j;

/**
 * 二叉树(BST - Binary Search Tree)
 *
 * @author jailmango
 * @CreateDate 2021/2/7
 * @see structure
 * @since R9.0
 */
@Slf4j
public class 二叉查找树 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node8 = new Node(8);
        Node node10 = new Node(10);

        node4.setLeft(node2);
        node4.setRight(node8);

        node2.setLeft(node1);
        node2.setRight(node3);

        node8.setLeft(node5);
        node8.setRight(node10);

        BST bst = new BST(node4);
        bst.add(9);

        log.info("end...");

    }

    private static class BST {

        public Node root;

        public BST(Node root) {
            this.root = root;
        }

        public void add(Integer value) {
            Node element = new Node(value);
            Node parent = null;
            while (true) {
                if (root == null) {
                    break;
                }

                parent = root;

                if (element.getValue().compareTo(root.getValue()) <= 0) {
                    root = root.left;
                }
                else {
                    root = root.right;
                }
            }

            if (parent != null) {
                if (element.value.compareTo(parent.value) <= 0) {
                    parent.left = element;
                }
                else {
                    parent.right = element;
                }
            }

            log.info("end...");
        }

        public void remove(Node element) {

        }
    }

    private static class Node {

        public Integer value;

        public boolean isRed;

        public Node parent;

        public Node left;

        public Node right;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
