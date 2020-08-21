package com.zw.algorithms.test2;

import java.util.Map;
import java.util.TreeMap;

/**
 * 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

/**
 * 思路
 *  1：排序
 *  2、hash
 *  3、摩尔投票法
 */
public class Test34 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    /**
     * 摩尔投票法：核心就是对拼消耗。
     * <p>
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。
     * 最后还有人活下来的国家就是胜利。
     * <p>
     * 那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），
     * 或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
     * <p>
     * 最后能剩下的必定是自己人。
     */
    public static int majorityElement(int[] nums) {
        int count = 0;

        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }

            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }

        return res;
    }

    public static int majorityElement1(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            Integer v = map.get(k);
            map.put(k, v == null ? 1 : ++v);
        }

        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            int k = en.getKey();
            int v = en.getValue();
            if (v > n) {
                return k;
            }
        }


        return 0;
    }
}
