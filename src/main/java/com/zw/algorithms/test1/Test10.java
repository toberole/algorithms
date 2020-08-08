package com.zw.algorithms.test1;

/**
 * 移除元素
 * <p>
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Test10 {
    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != val) {
                nums[j++] = nums[k];
            }
        }
        return j;
    }
}
