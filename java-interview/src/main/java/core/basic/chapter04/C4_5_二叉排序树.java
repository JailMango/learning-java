package core.basic.chapter04;

import lombok.extern.slf4j.Slf4j;

/**
 * C4_5_二叉排序树
 *
 * @author he.gang33
 * @CreateDate 2020/11/24
 * @see core.basic.chapter04
 * @since R9.0
 */
@Slf4j
public class C4_5_二叉排序树 {

    /**
     * Binary Search Tree
     */
    private class BST {
        private Node root;

        public void insertBST(int value) {
            Node p = root;
            Node prev = null;

            while (p != null) {
                prev = p;

                if (value < p.getValue()) {
                    p = p.getLeft();
                }
                else if (value > p.getValue()) {
                    p.getRight();
                }
                else {
                    return;
                }

                if (root == null) {
                    root = new Node(value);
                }
                else if (value < prev.getValue()) {
                    prev.setLeft(new Node(value));
                }
                else {
                    prev.setRight(new Node(value));
                }
            }
        }

        public void deleteBST(int value) {
            deleteBST(root, value);
        }

        public boolean searchBST(int value) {
            Node current = root;
            while (current != null) {
                if (value == current.getValue()) {
                    return true;
                }
                else if (value < current.getValue()) {
                    current = current.getLeft();
                }
                else {
                    current = current.getRight();
                }
            }
            return false;
        }

        private boolean deleteBST(Node root, int value) {
            if (root == null) {
                return false;
            }
            else {
                if (value == root.getValue()) {
                    return deleteNode(root);
                }
                else if (value < root.getValue()) {
                    return deleteBST(root.getLeft(), value);
                }
                else {
                    return deleteBST(root.getRight(), value);
                }
            }
        }

        private boolean deleteNode(Node node) {
            if (node.getRight() == null) {
                node = node.getLeft();
            }
            else if (node.getLeft() == null) {
                node = node.getRight();
            }
            else {
                Node m = node;
                Node n = node;

                n = n.getLeft();
                while (n.getRight() != null) {
                    m = n;
                    n = n.getRight();
                }

                node.setValue(n.getValue());

                if (m != node) {
                    m.setRight(n.getLeft());
                }
                else {
                    m.setLeft(n.getLeft());
                }
            }

            return true;
        }

        private class Node {

            private int value;

            private Node left;

            private Node right;

            public Node() {
            }

            public Node(int value) {
                this(value, null, null);
            }

            public Node(int value, Node left, Node right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
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
}
