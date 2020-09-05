package com.zw.algorithms.jzoffer.q2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 */
public class Test5 {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(twoSum(n));
    }

    public static double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];//dp[骰子个数][所有可能的值]
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {//i代表当前骰子的个数
            for (int j = i; j <= 6 * n; j++) {//j代表当前值的和
                for (int k = 1; k <= 6 && k <= j; k++) {//k代表当前筛子的值
                    //状态转移方程： i个骰子和为j += i-1个骰子和为j-k + 第i个骰子值为k
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        final double totalNum = Math.pow(6, n);//总次数
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / totalNum;
        }
        return ans;
    }

    public static double[] twoSum1(int n) {
        double[] res = new double[n * 6 - 6 + 1];
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr);
        }
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= 6; k++) {
                int[] temp = list.get(i);
                for (int j = 0; j < temp.length; j++) {

                }
            }
        }

        return res;
    }
}
