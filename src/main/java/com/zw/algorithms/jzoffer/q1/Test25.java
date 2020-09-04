package com.zw.algorithms.jzoffer.q1;

import java.util.Arrays;

/**
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 */
public class Test25 {
    public static void main(String[] args) {
        int[] nums = {14, 15, 16, 22, 53, 60};
        int target = 76;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     * 双指针
     */
    public static int[] twoSum(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int cur = nums[left] + nums[right];

            if (cur == target)
                return new int[]{nums[left], nums[right]};
            else if (cur > target)
                right--;
            else
                left++;
        }

        return new int[]{};
    }

    /**
     * 二分查找
     */
    public static int[] twoSum1(int[] nums, int target) {
        int res[] = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int other = target - n;
            if (other < n) {
                continue;
            }

            int findResIndex = findOther(nums, i + 1, nums.length - 1, other);
            if (findResIndex > 0) {
                res[0] = n;
                res[1] = nums[findResIndex];
                return res;
            }
        }
        return res;
    }

    public static int findOther(int[] nums, int l, int r, int target) {
        if (l >= r) return -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }

        return -l;
    }
}
