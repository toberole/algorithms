package com.zw.algorithms.jzoffer.q1;

/**
 * 打印从1到最大的n位数
 */
public class Test13 {
    public static void main(String[] args) {
        int n = 1;
        printNumbers(3);
    }

    public static int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }
        max = max - 1;
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }
}
