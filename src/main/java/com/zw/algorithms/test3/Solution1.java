package com.zw.algorithms.test3;

import com.zw.algorithms.bean.ListNode;

public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i]%2==1){
                i++;
                continue;
            }
            if (nums[j]%2==0){
                j--;
                continue;
            }

            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }

        return nums;
    }
}
