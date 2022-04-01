package com.jailmango.algorithm.geektime;

/**
 * 从尾到头打印链表
 *
 * @author jailmango
 * @CreateDate 2020/9/17
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
public class 从尾到头打印链表 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
//        ListNode originHead = new ListNode("0", null);
//        ListNode head = originHead;
//        ListNode next = null;
//
//        for (int i = 0; i < 10; i++) {
//            next = new ListNode(String.valueOf(i + 1), null);
//            head.next = next;
//            head = next;
//        }

        ListNode originHead = null;

        String[] arr = reversePrint(originHead);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static String[] reversePrint(ListNode head) {
        String[] result = null;
        int count = 0;

        ListNode reverseHead = null;
        ListNode reverseNext = null;

        while (head != null) {
            reverseHead = head;
            head = head.next;
            reverseHead.next = reverseNext;
            reverseNext = reverseHead;
            count++;
        }

        result = new String[count];
        int length = count;

        while (reverseHead != null) {
            result[length - count] = reverseHead.value;
            reverseHead = reverseHead.next;
            count--;
        }

        return result;
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
