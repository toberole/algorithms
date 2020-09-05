package com.zw.algorithms.jzoffer.q2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 扑克牌中的顺子
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Test6 {
    public static void main(String[] args) {
        int[] nums = {11, 8, 12, 8, 10};
        System.out.println(isStraight(nums));
    }

    public static boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    /**
     * 用 0 补缺
     * 0 不够用就是说明不是顺子
     */
    public static boolean isStraight1(int[] nums) {
        if (nums == null || nums.length <= 1) return true;

        sort(nums);

        int count_0 = 0;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count_0++;
                continue;
            }

            System.out.println("count_0: " + count_0);

            if (last == -1) {
                last = nums[i];
            } else {
                if (nums[i] - last == 1) {
                    last = nums[i];
                    if (i == nums.length - 1) return true;
                } else if (nums[i] - last == 0) {
                    return false;
                } else {
                    int n1 = nums[i] - last - 1;
                    if (n1 <= count_0) {
                        count_0 -= n1;

                        if (count_0 < 0) return false;
                        if (i == nums.length - 1) return true;

                        last = nums[i];
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean b = false;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    b = true;
                    int n = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = n;
                }
            }

            if (!b) {
                break;
            }
        }
    }
}
