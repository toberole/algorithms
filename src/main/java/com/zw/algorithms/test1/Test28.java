package com.zw.algorithms.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Test28 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }

    /**
     * 可使用异或运算,异或运算有以下三个性质。
     * 任何数和0做异或运算，结果仍然是原来的数，即 a ^ 0 = a。
     * 任何数和其自身做异或运算，结果是0，即 a ^ a = 0。
     * 异或运算满足交换律和结合律，即 a ^ b ^ a=b ^ a ^ a=b ^ (a ^ a)=b ^ 0 = b。
     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Integer v = map.get(n);
            if (v == null) {
                map.put(n, 0);
            } else {
                map.remove(n);
            }
        }

        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            return en.getKey();
        }

        return 0;
    }
}
