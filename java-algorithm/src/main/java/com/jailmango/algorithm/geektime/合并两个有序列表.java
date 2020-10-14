package com.jailmango.algorithm.geektime;

/**
 * 合并两个有序列表
 *
 * @author he.gang33
 * @CreateDate 2020/9/17
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
public class 合并两个有序列表 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode originNode = null;

        if (l1 == null) {
            originNode = l2;
        }
        else if (l2 == null) {
            originNode = l1;
        }
        else {
            if (l1.val <= l2.val) {
                originNode = l1;
                l1 = l1.next;
            }
            else {
                originNode = l2;
                l2 = l2.next;
            }

            ListNode curNode = originNode;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curNode.next = l1;
                    l1 = l1.next;
                }
                else {
                    curNode.next = l2;
                    l2 = l2.next;
                }
                curNode = curNode.next;
            }

            if (l1 == null) {
                curNode.next = l2;
            }
            else {
                curNode.next = l1;
            }
        }

        return originNode;
    }

    private static class ListNode {

        private int val;

        private ListNode next;
    }
}
