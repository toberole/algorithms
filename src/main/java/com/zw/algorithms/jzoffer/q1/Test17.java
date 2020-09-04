package com.zw.algorithms.jzoffer.q1;

import com.zw.algorithms.bean.ListNode;
import org.omg.CORBA.INVALID_TRANSACTION;

/**
 * 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Test17 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode l1 = ListNode.createList_tail(nums1);
        ListNode l2 = ListNode.createList_tail(nums2);
        ListNode l = mergeTwoLists(l1, l2);
        ListNode.printList(l);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode l1p = l1.next;
        ListNode l2p = l2.next;

        l1.next = null;
        ListNode temp;
        ListNode last = l1;

        while (l1p != null && l2p != null) {
            if (l1p.val <= l2p.val) {
                temp = l1p;
                l1p = l1p.next;
                temp.next = last.next;
                last.next = temp;
                last = temp;
            } else {
                temp = l2p;
                l2p = l2p.next;
                temp.next = last.next;
                last.next = temp;
                last = temp;
            }
        }

        if (l1p != null) {
            last.next = l1p;
        }

        if (l2p != null) {
            last.next = l2p;
        }


        return l1;
    }
}
