package com.zw.algorithms.test3;

import com.zw.util.Util;

public class Solution4 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int n = nums[i] + nums[j];
            if (n > target) {
                j--;
            } else if (n < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }

        return new int[0];

    }

    public int[][] findContinuousSequence(int target) {

        return null;
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        Util.printArray(twoSum(arr, 9));
    }
}
