package com.zw.algorithms.jzoffer.q1;

/**
 * 斐波那契数列
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class Test8 {
    public static void main(String[] args) {
        System.out.println(fib(45));
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c ;
        }
        return c% 1000000007;
    }
}
