package com.jailmango.algorithm.geektime;

/**
 * 单链表删除节点
 *
 * @author he.gang33
 * @CreateDate 2020/9/17
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
public class 单链表删除节点 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ListNode originHead = new ListNode("0", null);
        ListNode head = originHead;
        ListNode next = null;

        for (int i = 0; i < 10; i++) {
            next = new ListNode(String.valueOf(i + 1), null);
            head.next = next;
            head = next;
        }
    }

    public static ListNode deleteNode(ListNode head, String value) {
        ListNode originHead = head;
        ListNode prevNode = null;

        while (head != null) {
            if (head.value.equals(value)) {
                if (prevNode == null) {
                    originHead = head.next;
                }
                else {
                    prevNode.next = head.next;
                }
                break;
            }

            prevNode = head;
            head = head.next;
        }

        return originHead;
    }

    private static class ListNode {

        private String value;

        private ListNode next;

        public ListNode(String value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
