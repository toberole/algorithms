package com.zw.algorithms.test3;

import com.zw.util.Util;

public class Sort {
    /**
     * 插入排序
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {  //在有序区间中找合适的插入位置
                if (array[j] <= key) {
                    break;
                } else {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = key;
        }
    }

    public static void insertSort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] < temp) break;

                // 后移
                array[j + 1] = array[j];
            }

            array[j] = temp;
        }
    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {  //循环需要进行array.length-1次
            int maxIndex = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(array, maxIndex, array.length - 1 - i);
            //每次将最大数放到无序区间的最后
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void selectSort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) return;

        for (int i = 0; i < array.length - 1; i++) {
            boolean b = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    b = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if (b) break;
        }
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (arr == null || begin >= end) return;

    }

    public static void main(String[] args) {
//        selectSort1(Util.arr);
//        Util.printArray(Util.arr);

        bubbleSort(Util.arr);
        Util.printArray(Util.arr);
    }
}