package com.zw.algorithms.test1;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Test14_X {
    public static void main(String[] args) {
        int nums[] = {-2, -3};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 动态规划思想：
     * <p>
     * 假设sum<=0，那么后面的子序列肯定不包含目前的子序列[负值只会导致最终结果减小]，所以令sum = num；
     * 如果sum > 0对于后面的子序列是有好处的。res = Math.max(res, sum)保证可以找到最大的子序和。
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];

        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }


    /**
     * 暴力循环
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length - i; j++) {
                int n = 0;
                for (int k = j; k < j + i; k++) {
                    n += nums[k];
                }

                if (n > max) {
                    max = n;
                }
            }
        }

        return max;
    }
}
