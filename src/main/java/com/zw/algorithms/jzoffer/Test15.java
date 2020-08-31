package com.zw.algorithms.jzoffer;

import com.zw.algorithms.bean.ListNode;

/**
 * 链表中倒数第k个节点
 */
public class Test15 {
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = ListNode.createList_tail(nums);
        System.out.println(getKthFromEnd(head, 1));
    }

    /**
     * 快慢指针，先让快指针走k步，然后两个指针同步走，当快指针走到头时，慢指针就是链表倒数第k个节点。
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fastNode = head;
        ListNode lowNode = head;
        while (fastNode != null && k > 0) {
            fastNode = fastNode.next;
            k--;
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            lowNode = lowNode.next;
        }

        return lowNode;
    }

    public static ListNode getKthFromEnd1(ListNode head, int k) {

        ListNode h = head;
        head = head.next;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        int n = len - k;
        h = h.next;
        while (n > 0) {
            n--;
            h = h.next;
        }

        return h;
    }
}
