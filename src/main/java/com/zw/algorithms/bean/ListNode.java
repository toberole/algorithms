package com.zw.algorithms.bean;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 尾插法
     */
    public static ListNode createList_tail(int[] arr) {
        // 头节点
        ListNode head = new ListNode();
        ListNode l = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            l.next = temp;
            l = temp;
        }

        return head;
    }

    /**
     * 头插法
     */
    public static ListNode createList_head(int[] arr) {
        ListNode head = new ListNode();
        for (int i = 0; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            temp.next = head.next;
            head.next = temp;
        }
        return head;
    }

    public static void printList(ListNode l) {
        if (l == null) return;
        StringBuffer sb = new StringBuffer();

        while ((l = l.next) != null) {
            sb.append(l.val).append(" ");
        }

        System.out.println(sb.toString());
    }

}
