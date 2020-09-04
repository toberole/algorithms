package com.zw.algorithms.jzoffer.q1;

import com.zw.algorithms.bean.ListNode;

/**
 * 两个链表的第一个公共节点
 */
public class Test2 {
    public static void main(String[] args) {
        int[] listA = {4, 1, 8, 4, 5};
        int[] listB = {5, 0, 1, 8, 4, 5};
        ListNode head_a = ListNode.createList_tail(listA);
        ListNode head_b = ListNode.createList_tail(listB);
        getIntersectionNode(head_a, head_b);
    }

    /**
     * 相遇法
     * 使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
     * <p>
     * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            if (node1 == null) {
                node1 = headB;
                node2 = node2.next;
                continue;
            }
            if (node2 == null) {
                node2 = headA;
                node1 = node1.next;
                continue;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;

    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = ListNode.getListLen(headA);
        int lenB = ListNode.getListLen(headB);
        int n = (lenA - lenB) > 0 ? lenA - lenB : lenB - lenA;
        System.out.println(n);
        ListNode node1;
        ListNode node2;
        if (lenA >= lenB) {
            node1 = headB.next;
            node2 = headA.next;
        } else {
            node1 = headA.next;
            node2 = headB.next;
        }

        while (node2 != null && n > 0) {
            node2 = node2.next;
            n--;
        }

        while (node1 != null && node2 != null) {
            if (node1 == node2) return node1;
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }
}
