package com.zw.algorithms.jzoffer.q1;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Test14 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        nums = exchange2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 一次快排
     */
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 找到左边的第一个偶数
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            // 找到右边的第一个奇数
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    /**
     * 用i当作奇数的索引位置，j为偶数的索引位置。
     */
    public static int[] exchange2(int[] nums) {
        int temp, j = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] % 2 == 1) {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                ++j;
            }
            i++;
        }
        return nums;
    }

    public static int[] exchange1(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int[] temp = new int[nums.length];
        int p1 = 0;
        int p2 = nums.length - 1;

        for (int i = 0; p1 <= p2; i++) {
            if (nums[i] % 2 == 1) {
                temp[p1++] = nums[i];
            } else {
                temp[p2--] = nums[i];
            }
        }

        return temp;
    }
}
