package com.zw.algorithms.sort;

import java.util.Arrays;

public class MergeSort_L {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5};
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = nums[i++];
        }

        while (j <= right) {
            temp[index++] = nums[j++];
        }

        index = 0;
        while (left <= right) {
            nums[left++] = temp[index++];
        }
    }
}
