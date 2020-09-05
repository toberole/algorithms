package com.zw.algorithms.jzoffer.q2;

import java.util.Arrays;

/**
 * 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 * <p>
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class Test9 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(constructArr(nums)));
    }


    public static int[] constructArr(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int product = 1;
        /* 从左往右累乘 */
        for (int i = 0; i < n; i++) {
            res[i] = product;
            product *= arr[i];
        }

        System.out.println(Arrays.toString(res));

        product = 1;
        /* 从右往左累乘 */
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= product;
            product *= arr[i];
        }

        return res;
    }

    /**
     * 效率低
     */
    public static int[] constructArr1(int[] arr) {
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int n = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    n *= 1;
                } else {
                    n *= arr[j];
                }
            }

            res[i] = n;
        }
        return res;
    }
}
