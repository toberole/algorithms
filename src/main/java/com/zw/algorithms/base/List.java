package com.zw.algorithms.base;


import com.zw.algorithms.bean.ListNode;

public class List {
    /**
     * 判断链表是否有环
     */
    public boolean exitLoop(ListNode head) {
        if (head == null) return false;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p1 != null && p2 != null) {
            if (p1 == p2) return true;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return false;
    }

    /**
     * 找到环的入口
     * @param head
     * @return
     */
    public ListNode findLoopStart(ListNode head) {
        if (head == null) return null;

        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l1 != null && l2 != null) {
            if (l1 == l2) break;

            l1 = l1.next;
            l2 = l2.next.next;
        }

        if (l1 == null || l2.next == null) return null;

        l1 = head;
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }
}
