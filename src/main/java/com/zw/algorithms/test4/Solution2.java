package com.zw.algorithms.test4;

import java.util.Arrays;

public class Solution2 {
    public static int count = 0;

    public static void Permutation(char chs[], int start) {
        if (start == chs.length - 1) {
            count++;
            System.out.println(Arrays.toString(chs));
        }

        for (int i = start; i < chs.length; i++) {
            Swap(chs, i, start);
            Permutation(chs, start + 1);
            Swap(chs, i, start);
        }
    }

    public static void Swap(char chs[], int i, int j) {
        char temp;
        temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e'};
        Permutation(arr, 0);

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
