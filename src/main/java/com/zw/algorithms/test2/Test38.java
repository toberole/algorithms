package com.zw.algorithms.test2;

/**
 * 位1的个数
 * <p>
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * <p>
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 */
public class Test38 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int end = n & 1;
            if (end == 1) res++;
            n = n >> 1;
        }

        return res;
    }
}
