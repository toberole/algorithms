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
        if (arr == null || arr.length < 2 || begin >= end) return;

        int temp = arr[begin]; //将区间的第一个数作为基准数
        int i = begin; //从左到右进行查找时的“指针”，指示当前左位置
        int j = end; //从右到左进行查找时的“指针”，指示当前右位置
        //不重复遍历
        while (i < j) {
            //当右边的数大于基准数时，略过，继续向左查找
            //不满足条件时跳出循环，此时的j对应的元素是小于基准元素的
            while (i < j && arr[j] > temp) j--;
            //将右边小于等于基准元素的数填入右边相应位置
            arr[i] = arr[j];
            //当左边的数小于等于基准数时，略过，继续向右查找
            //(重复的基准元素集合到左区间)
            //不满足条件时跳出循环，此时的i对应的元素是大于等于基准元素的
            while (i < j && arr[i] <= temp) i++;
            //将左边大于基准元素的数填入左边相应位置
            arr[j] = arr[i];
        }
        //将基准元素填入相应位置
        arr[i] = temp;
        //此时的i即为基准元素的位置
        //对基准元素的左边子区间进行相似的快速排序
        quickSort(arr, begin, i - 1);
        //对基准元素的右边子区间进行相似的快速排序
        quickSort(arr, i + 1, end);

    }


    public static void main(String[] args) {
//        selectSort1(Util.arr);
//        Util.printArray(Util.arr);

        bubbleSort(Util.arr);
        Util.printArray(Util.arr);
    }
}