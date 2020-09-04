package com.zw.algorithms.jzoffer.q1;

/**
 * 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Test22 {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }

    // 有序数组直接二分
    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // 小于等于
        while (left <= right) {
            // 防溢出的写法，位运算提速，
            // 这里注意位运算的优先级问题，需要用括号括起来
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static int missingNumber1(int[] nums) {
        int i;
        int j;

        for (i = 0, j = nums.length; i <= j; i++, j--) {

            System.out.println("i: " + i + ",j: " + j);

            if (nums[i] != i || nums[j - 1] != j) {
                if (nums[i] != i) return i;

                if (nums[j - 1] != j) return j;
            }
        }


        return -1;
    }
}
