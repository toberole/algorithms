package com.zw.algorithms.test1;

import com.zw.algorithms.bean.ListNode;

public class Test29 {
    public static void main(String[] args) {

    }

    /**
     * 判断链表是否有环
     * <p>
     * 快慢指针法
     * <p>
     * 慢指针步长为 1，快指针步长为 2
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 求链表环的长度
     * <p>
     * 快慢指针法中，两个指针的速度差为1。所以当两个指针第二次相遇时，指针P1走了2倍环的长度，
     * 而指针1走了环的长度。所以指针第一次相遇到第二次相遇之间，指针的移动次数就是换的长度。
     */
    public int cycleLen(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;

        int len = -1;
        while (fast != null) {
            if (fast == slow) {
                if (len == -1) {// 第一次相遇
                    len = 0;
                } else {// 第二次相遇
                    return ++len;
                }
            } else {
                if (len >= 0) {// 只有在第一相遇之后 才开始计算长度
                    len++;
                }

                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
            }
        }

        return 0;
    }

    /**
     * 环外链表的长度 = 第一次相遇点 + n-1次环的长度
     * <p>
     * 所以只需要将其中一个指针移动到链表头部，另一个指针保持在第一次相遇位置，
     * 两个指针同时出发，且行进速度为一个节点，再次相遇点则为环的入口。
     */
    public static ListNode cycleEnter(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;

        boolean b = false;
        while (fast != null) {
            if (fast == slow) {
                if (b) return fast;

                b = true;
                slow = head;
            } else {
                slow = slow.next;
                if (!b) {
                    fast = fast.next.next;
                } else {
                    // 相遇之后 步长变为 1
                    fast = fast.next;
                }
            }
        }

        return null;
    }
}
