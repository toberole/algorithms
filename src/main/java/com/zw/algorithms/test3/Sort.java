package com.zw.algorithms.test3;

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
}
