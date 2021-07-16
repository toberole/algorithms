package com.zw.algorithms.test4;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 1;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    public int cuttingRope1(int n) {
        if (n <= 3) return n - 1;
        long res = 1L;
        int p = (int) 1e9 + 7;
        //贪心算法，优先切三，其次切二
        while (n > 4) {
            res = res * 3 % p;
            n -= 3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int) (res * n % p);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

    }
}
