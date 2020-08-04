package com.zw.algorithms.test1;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Test3 {
    public static void main(String[] args) {
        int n = -121;
        System.out.println("n: " + n + ",isPalindrome: " + isPalindrome(n));
    }

    /**
     * 反转数字 比较反转之后的数字是否与之前的数字相等
     */
    public static boolean isPalindrome(int x) {
        if (x == 0) return true;

        if (x % 10 == 0 || x < 0) return false;

        if (x < 10) return true;

        int temp = x;

        // 数字反转的基本套路
        int k = 0;
        while (x != 0) {
            k = k * 10 + x % 10;
            x = x / 10;
        }

        System.out.println("k: " + k);

        return (k == temp);
    }
}
