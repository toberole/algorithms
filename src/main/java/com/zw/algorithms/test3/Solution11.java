package com.zw.algorithms.test3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution11 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int zeroCnt = 0;
        int diff = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                if (nums[i] == nums[i + 1]) return false;
                if (nums[i] + 1 != nums[i + 1]) {
                    diff += nums[i + 1] - nums[i] - 1;
                }
            }
        }
        return zeroCnt >= diff;
    }

    public boolean isStraight1(int[] nums) {
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

    public static int lastRemaining(int n, int m) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        int k = n;
        int cnt = 0;
        while (k > 1) {
            for (int i = 0; i < m; i++) {
                while (arr[cnt % n] == -1) {
                    cnt++;
                    cnt = cnt % n;
                }

                if (i == m - 1) {
                    arr[cnt] = -1;
                }

                cnt++;
                cnt = cnt % n;
            }
            k--;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) return arr[i];
        }

        return 0;
    }

    public int lastRemaining1(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(lastRemaining(5, 3));
    }
}
