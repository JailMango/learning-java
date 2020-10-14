package com.jailmango.algorithm.geektime;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 链表中环的检测
 *
 * @author he.gang33
 * @CreateDate 2020/9/17
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 链表中环的检测 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ListNode originHead = new ListNode(0, null);
        ListNode head = originHead;
        ListNode next = null;

        for (int i = 0; i < 10; i++) {
            next = new ListNode((i + 1), null);
            head.next = next;
            head = next;
        }

        head.next = originHead;

        log.info("has cycle: {}", hasCycle(originHead));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    private static class ListNode {
        int val;

        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
