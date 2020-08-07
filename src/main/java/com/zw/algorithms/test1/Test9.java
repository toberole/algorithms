package com.zw.algorithms.test1;

/**
 * 计算斐波那契数列：F(n)=F(n-1)+F(n-2) (n为自然数，F(0)=0,F(1)=1)。
 */
public class Test9 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("fibonacci: " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
