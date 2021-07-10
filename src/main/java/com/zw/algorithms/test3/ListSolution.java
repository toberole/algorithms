package com.zw.algorithms.test3;

import com.zw.algorithms.bean.ListNode;

public class ListSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        ListNode a = headA;
        while (headA != null) {
            len1++;
            headA = headA.next;
        }

        ListNode b = headB;
        int len2 = 0;
        while (headB != null) {
            len2++;
            headB = headB.next;
        }

        int k = len1 > len2 ? len1 - len2 : len2 - len1;
        if (len1 > len2) {
            while (k > 0) {
                k--;
                a = a.next;
            }
        } else if (len1 < len2) {
            while (k > 0) {
                k--;
                b = b.next;
            }
        }

        while (a != null && b != null) {
            if (a == b) return a;

            a = a.next;
            b = b.next;
        }

        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            node1 = (node1 != null) ? node1.next : headB;
            node2 = (node2 != null) ? node2.next : headA;
        }

        return node1;
    }

}
