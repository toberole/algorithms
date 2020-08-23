package com.zw.algorithms.jzoffer;

import com.zw.algorithms.bean.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Test6 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNode.createList_tail(nums);
        reversePrint(head);
    }

    /**
     * 就地反转链表
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode node = head.next;
        head.next = null;

        int len = 0;
        ListNode temp;
        while (node != null) {
            len++;

            temp = node;
            node = node.next;
            temp.next = head.next;
            head.next = temp;
        }

        int nums[] = new int[len];
        int index = 0;
        head = head.next;
        while (head != null) {
            nums[index++] = head.val;
            head = head.next;
        }

        System.out.println(Arrays.toString(nums));

        return nums;
    }

    /**
     * 第一种方式
     * 使用Statck
     */
    public int[] reversePrint1(ListNode head) {
        if (head == null || head.next == null) return null;
        Stack<Integer> stack = new Stack<>();
        head = head.next;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int n = stack.size();
        int nums[] = new int[n];
        int index = 0;
        while (!stack.isEmpty()) {
            int k = stack.pop();
            nums[index++] = k;
        }

        return nums;
    }
}
