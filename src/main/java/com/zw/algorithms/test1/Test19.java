package com.zw.algorithms.test1;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * f(n) = f(n-1)+f(n-2)
 */
public class Test19 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
            ret = a + b;
            a = b;
            b = ret;
        }

        return ret;
    }
}
