package com.jailmango.algorithm.geektime;

import lombok.extern.slf4j.Slf4j;

/**
 * DailyExercise
 *
 * @author he.gang33
 * @CreateDate 2020/9/18
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class DailyExercise {

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

        ListNode reserve = reverse(originHead);
        log.info("end...");
    }

    public static ListNode reverse(ListNode head) {
        ListNode reserveNode = head;
        ListNode reservPrev = null;

        while (head != null) {
            reserveNode = head;
            head = head.next;
            reserveNode.next = reservPrev;
            reservPrev = reserveNode;
        }

        return reserveNode;
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
