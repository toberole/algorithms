package com.zw.algorithms.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        m1(nums, target);

        m2(nums, target);

    }

    // 遍历 时间复杂度 O(n2)
    public static void m1(int[] nums, int target) {

        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }

        System.out.println("index1: " + index1);
        System.out.println("index2: " + index2);
    }

    // 使用hashmap
    public static void m2(int[] nums, int target) {
        int index1 = -1;
        int index2 = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            Integer index = map.get(sub);
            if (index != null) {
                index1 = i;
                index2 = index;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        System.out.println("index1: " + index1);
        System.out.println("index2: " + index2);
    }
}
