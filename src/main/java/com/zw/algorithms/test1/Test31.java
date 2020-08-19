package com.zw.algorithms.test1;

import com.zw.algorithms.bean.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 思路：
 * 1、分别求出链表的长度为L1,L2,即L1与L2差为n
 * 2、长链表先走n步，然后两个链表同时走，第一次相遇则即是相交的起始节点
 */
public class Test31 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int n = Math.abs(lenA - lenB);
        ListNode h1 = null;
        ListNode h2 = null;

        if (lenA > lenB) {
            h1 = headA;
            h2 = headB;
        } else {
            h1 = headB;
            h2 = headA;
        }

        while (n > 0) {
            h1 = h1.next;
            n--;
        }

        while (h1 != null && h2 != null) {
            if (h1 == h2) return h1;

            h1 = h1.next;
            h2 = h2.next;
        }

        return null;
    }

    public static int getLen(ListNode head) {
        if (head == null) return 0;

        head = head.next;
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }

        return len;
    }
}
