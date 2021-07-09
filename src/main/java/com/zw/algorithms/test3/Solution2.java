package com.zw.algorithms.test3;

import com.zw.algorithms.bean.ListNode;
import com.zw.util.Util;


public class Solution2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return head;

        ListNode l1 = head;

        ListNode l2 = head;
        for (int i = 0; i < k - 1; i++) {
            l2 = l2.next;
        }

        while (l2.next != null) {
            l2 = l2.next;
            l1 = l1.next;
        }

        return l1.next;
    }

    public static int[] printNumbers(int n) {
        if (n == 0) return new int[0];
        int max = 1;
        while (n > 0) {
            n--;
            max *= 10;
        }

        int ret[] = new int[max - 1];
        for (int i = 0; i < max - 1; i++) {
            ret[i] = i + 1;
        }

        return ret;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode l = new ListNode(0);

        while (head != null) {
            ListNode ll = head.next;
            head.next = l.next;
            l.next = head;
            head = ll;
        }

        return l.next;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;

        ListNode pre = head;
        ListNode p = head.next;

        if (head.val == val) return head.next;

        ListNode res = pre;

        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                break;
            } else {
                pre = p;
                p = p.next;
            }
        }

        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k <= 0) return new int[0];

        for (int i = 0; i < arr.length - 1; i++) {
            boolean b = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;

                    b = true;
                }
            }

            if (!b) break;
        }

        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Util.printArray(printNumbers(3));
    }
}
