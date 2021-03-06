package com.zw.algorithms.test1;

import com.zw.algorithms.bean.ListNode;

/**
 * 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Test7 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        ListNode l1 = ListNode.createList_tail(arr1);
        ListNode.printList(l1);

        int[] arr2 = {1, 3, 4};
        ListNode l2 = ListNode.createList_tail(arr2);
        ListNode.printList(l2);

        ListNode l3 = mergeTwoLists(l1, l2);
        ListNode.printList(l3);
    }

    /**
     * @param l1 带有头节点的链表
     * @param l2 带有头节点的链表
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p = res;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                p.next = l1;
                p = l1;
                l1 = l1.next;

                p.next = l2;
                p = l2;
                l2 = l2.next;
            } else if (l1.val > l2.val) {
                p.next = l2;
                p = l2;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }
        }

        if (l1 == null && l2 != null) {
            p.next = l2;
        } else if (l2 == null && l1 != null) {
            p.next = l1;
        } else {
            p.next = null;
        }

        return res;
    }
}

