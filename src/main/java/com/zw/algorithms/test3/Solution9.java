package com.zw.algorithms.test3;

public class Solution9 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //  [-2,1,-3,4,-1,2,1,-5,4]
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            ret = Math.max(ret, nums[i]);
        }
        return ret;
    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] != 0) return 0;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return 0;
    }

    public static int missingNumber1(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return i;
    }

    public static void main(String[] args) {

    }
}
