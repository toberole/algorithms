package com.zw.algorithms.jzoffer;

import com.zw.algorithms.bean.ListNode;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Test16 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createList_tail(nums);
        ListNode.printList(head);
        head = reverseList(head);
        ListNode.printList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode p = head.next;
        ListNode temp = null;
        head.next = null;

        while (p != null) {
            temp = p;
            p = p.next;
            temp.next = head.next;
            head.next = temp;
        }

        return head;
    }
}
