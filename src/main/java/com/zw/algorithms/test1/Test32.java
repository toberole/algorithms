package com.zw.algorithms.test1;

/**
 * 两数之和 II - 输入有序数组
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Test32 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        int res[] = twoSum(numbers, target);
        System.out.println("res[0]: " + res[0] + ",res[1]: " + res[1]);

        // System.out.println(b_s(numbers, 0, numbers.length - 1, 2));
    }

    /**
     * 双指针法
     */
    public static int[] twoSum(int[] numbers, int target) {
        int res[] = {-1, -1};
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int n = numbers[i] + numbers[j];

            if (n == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            } else if (n > target) {
                j--;
            } else {
                i++;
            }
        }

        return res;
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int res[] = {-1, -1};
        for (int i = 0; i < numbers.length; i++) {
            int n = target - numbers[i];
            int index = b_s(numbers, i, numbers.length - 1, n);
            if (index >= 0) {
                res[0] = i + 1;
                res[1] = index + 1;
                return res;
            }
        }
        return res;
    }

    public static int b_s(int[] numbers, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        while (start <= end && start >= 0 && end < numbers.length) {
            if (numbers[mid] == k) {
                if (mid + 1 < numbers.length && numbers[mid + 1] == numbers[mid]) {
                    return mid + 1;
                } else {
                    return mid;
                }
            }

            if (numbers[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = (start + end) / 2;
        }

        return -1;
    }
}
