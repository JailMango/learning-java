package com.jailmango.algorithm.geektime;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * @author he.gang33
 * @CreateDate 2020/9/18
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
public class 删除链表的倒数第N个节点 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 构造一个头结点
        ListNode newHead = new ListNode(-1, head);
        ListNode slow = newHead;
        ListNode fast = newHead;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return newHead.next;
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
