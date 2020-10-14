package com.jailmango.algorithm.geektime;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 单链表反转
 *
 * @author he.gang33
 * @CreateDate 2020/9/17
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 单链表反转 {

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

        ListNode reverseHead = reverse(originHead);

        log.info("end...");
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverseHead = null;
        ListNode reverseNext = null;

        while (head != null) {
            reverseHead = head;
            head = head.next;
            reverseHead.next = reverseNext;
            reverseNext = reverseHead;
        }

        return reverseHead;
    }

    @AllArgsConstructor
    @ToString
    private static class ListNode {

        private String value;

        private ListNode next;

    }
}
