package com.zw.algorithms.jzoffer.q2;

/**
 * 不用加减乘除做加法
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class Test8 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println(add(a, b));
    }

    public static int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}
