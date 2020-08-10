package com.zw.algorithms.test1;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Test18 {
    public static void main(String[] args) {
        int x = 2147395600;
        System.out.println(mySqrt(x));
    }

    /**
     * 二分查找，用x/m<m而不是m*m>x防止溢出
     */
    public static int mySqrt(int x) {
        if (x == 1)
            return 1;
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int m = (max + min) / 2;
            if (x / m < m) {
                max = m;
            } else {
                min = m;
            }
        }
        return min;
    }
}
