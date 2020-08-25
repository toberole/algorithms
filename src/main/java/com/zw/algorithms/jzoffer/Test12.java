package com.zw.algorithms.jzoffer;

/**
 * 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
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
public class Test12 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }

//    public static int hammingWeight(int n) {
//        int ret = 0;
//        while (n != 0) {
//            int t = n % 2;
//            if (t == 1) {
//                ret++;
//            }
//            n = n / 2;
//        }
//
//        return ret;
//    }

    public static int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 0x00000001) == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}
