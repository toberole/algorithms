package com.zw.algorithms.jzoffer.q1;

/**
 * 青蛙跳台阶问题
 * <p>
 * 动态规划思想
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class Test9 {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    public static int numWays(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            res = res % 1000000007;
            a = b;
            b = res;
        }
        return res;
    }
}
