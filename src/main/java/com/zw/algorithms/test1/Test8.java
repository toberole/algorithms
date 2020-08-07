package com.zw.algorithms.test1;

/**
 * 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Test8 {
    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Duplicates: " + removeDuplicates(nums));
    }


    /**
     * 双指针法
     * <p>
     * 首先注意数组是有序的，那么重复的元素一定会相邻。
     * <p>
     * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
     * <p>
     * 考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
     * <p>
     * 1.比较 p 和 q 位置的元素是否相等。
     * <p>
     * 如果相等，q 后移 1 位
     * 如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
     * 重复上述过程，直到 q 等于数组长度。
     * <p>
     * 返回 p + 1，即为新数组长度。
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }

        }
        return j + 1;
    }
}
