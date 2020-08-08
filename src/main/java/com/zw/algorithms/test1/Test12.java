package com.zw.algorithms.test1;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Test12 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    // 使用二分法
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int low = 0;
        int height = nums.length - 1;
        while (low <= height) {
            int mid = (low + height) / 2;
            if (nums[mid] > target) {
                height = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }
}
