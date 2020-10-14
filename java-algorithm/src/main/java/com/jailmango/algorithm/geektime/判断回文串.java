package com.jailmango.algorithm.geektime;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 判断回文链表 Palindrome List
 * 
 * @author he.gang33
 * @CreateDate 2020/9/16
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 判断回文串 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        // ListNode head = new ListNode("0", null);
        // ListNode prev = head;
        // ListNode next = null;
        //
        // for (int i = 0; i < 10; i++) {
        // next = new ListNode(String.valueOf(i + 1), null);
        // prev.next = next;
        // prev = next;
        //
        // }

        ListNode node4 = new ListNode("a", null);
        ListNode node3 = new ListNode("b", node4);
        ListNode node2 = new ListNode("c", node3);
        ListNode node1 = new ListNode("b", node2);
        ListNode node0 = new ListNode("a", node1);

        log.info("is palindrome: {}", isPalindrome(node0));

        ListNode node5 = new ListNode("a", null);
        node4 = new ListNode("b", node5);
        node3 = new ListNode("c", node4);
        node2 = new ListNode("c", node3);
        node1 = new ListNode("b", node2);
        node0 = new ListNode("a", node1);

        log.info("is palindrome: {}", isPalindrome(node0));

        log.info("end...");
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode reversedListHead = null;
        ListNode tmp = null;

        while (fast != null && fast.next != null) {
            reversedListHead = slow;
            slow = slow.next;
            fast = fast.next.next;
            reversedListHead.next = tmp;
            tmp = reversedListHead;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (reversedListHead != null && slow != null) {
            if (!reversedListHead.getValue().equals(slow.getValue())) {
                return false;
            }

            reversedListHead = reversedListHead.next;
            slow = slow.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head) {
        return null;

    }

    @Data
    @ToString
    private static class ListNode {

        /**
         * value
         */
        String value;

        /**
         * next node
         */
        ListNode next;

        public ListNode(String value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
