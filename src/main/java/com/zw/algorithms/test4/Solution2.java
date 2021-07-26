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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int len = m + n;

        int left = -1;
        int right = -1;

        int aStart = 0;
        int bStart = 0;

        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }

        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int p1 = 0;
        int p2 = 0;

        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i <= (l1 + l2) / 2; i++) {
            i1 = i2;
            if (p1 < l1 && (p2 >= l2 || nums1[p1] < nums2[p2])) {
                i2 = nums1[p1++];
            } else {
                i2 = nums2[p2++];
            }
        }

        if ((l1 + l2) / 2 == 0) {
            return (i1 + i2) / 2;
        }

        return i2;
    }

    public static void test1() {
        char[] arr = {'a', 'b', 'c', 'd', 'e'};
        Permutation(arr, 0);

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }

    public static void test2() {
        int[] arr1 = {1, 2, 3};

    }

    public static void main(String[] args) {

    }
}
