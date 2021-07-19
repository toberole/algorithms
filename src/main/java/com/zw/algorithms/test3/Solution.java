package com.zw.algorithms.test3;

import com.zw.algorithms.bean.ListNode;

import java.util.Stack;

public class Solution {


    public int[] reversePrint(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p = head;

        int n = 0;
        while (head.next != null) {
            n++;
            head = head.next;
        }

        int res[] = new int[n];
        p = p.next;
        while (p != null) {
            res[n - 1] = p.val;
            p = p.next;
            n--;
        }

        return res;
    }

    public int[] reversePrint2(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop().val;
        }

        return arr;
    }

    public int[] reversePrint3(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("hello");

        System.out.println(stack.size());
    }
}
