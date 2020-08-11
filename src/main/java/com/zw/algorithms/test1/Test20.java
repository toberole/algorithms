package com.zw.algorithms.test1;

import com.zw.algorithms.bean.ListNode;

/**
 *
 * 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Test20 {
    public static void main(String[] args) {
        int nums[] = {1, 1, 2};
        ListNode list = ListNode.createList_tail(nums);
        list = deleteDuplicates(list);
        ListNode.printList(list);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode l1 = head.next;
        ListNode l2 = head.next;

        while (l2 != null) {
            if (l2.val != l1.val) {
                l1.next = l2;
                l1 = l2;
                l2 = l2.next;
            } else {
                l2 = l2.next;
                if (l2 == null) {
                    l1.next = null;
                }
            }
        }

        return head;
    }
}
