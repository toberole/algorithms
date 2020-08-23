package com.zw.algorithms.jzoffer;

/**
 * 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Test3 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        System.out.println(findRepeatNumber(nums));
    }

    /**
     * 鸽巢原理，因为出现的元素值 < nums.size(); 所以我们可以将见到的元素 放到索引的位置，
     * 如果交换时，发现索引处已存在该元素，则重复
     * O(N) 空间O(1)
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            int n = temp[index];

            if (n == -1) {
                temp[index] = index;
            } else {
                return n;
            }
        }
        return 0;
    }
}
