package com.jailmango.algorithm.geektime;

import lombok.extern.slf4j.Slf4j;

/**
 * 876. 链表的中间节点
 *
 * @author he.gang33
 * @CreateDate 2020/9/18
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 链表的中间节点 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode result = middleNode(node1);

        log.info("end...");
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // fast == null -> middle = slow;

        if (fast != null) {
            slow = slow.next;
        }

        return slow;
    }

    private static class ListNode {

        private int val;

        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
