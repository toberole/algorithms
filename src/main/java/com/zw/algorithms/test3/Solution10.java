package com.zw.algorithms.test3;

import java.util.ArrayList;

public class Solution10 {
    public static ArrayList<Integer> printMatrixClockwisely(int[][] nums) {
        if (nums == null) return null;
        int rows = nums[0].length;
        int cols = nums.length;
        if (rows <= 0 || cols <= 0) return null;

        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;

        while (rows > 2 * start && cols > 2 * start) {
            printMatrixInCircle(res, nums, cols, rows, start);
            start++;
        }

        return res;
    }

    /**
     * 打印一圈
     */
    private static void printMatrixInCircle(
            ArrayList<Integer> list, int[][] nums,
            int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        System.out.println("endX: " + endX + ",endY: " + endY);

        // 从左到右打印一行
        for (int i = start; i <= endX; ++i) {
            int number = nums[start][i];
            list.add(number);
        }

        // 从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                int number = nums[i][endX];
                list.add(number);
            }
        }

        // 从右向左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                int number = nums[endY][i];
                list.add(number);
            }
        }

        // 从下向上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                int number = nums[i][start];
                list.add(number);
            }
        }
    }

    private static void printMatrixInCircle2(int[][] nums, int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        System.out.println("endX: " + endX + ",endY: " + endY);

        // 从左到右打印一行
        for (int i = start; i <= endX; ++i) {
            int number = nums[start][i];
            System.out.println(number);
        }

        // 从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                int number = nums[i][endX];
                System.out.println(number);
            }
        }

        // 从右向左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                int number = nums[endY][i];
                System.out.println(number);
            }
        }

        // 从下向上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                int number = nums[i][start];
                System.out.println(number);
            }
        }
    }

    private static void printMatrixInCircle1(int[][] nums, int cols, int rows, int start) {
        int endX = cols - start - 1;
        int endY = rows - start - 1;

        // 左 到 右
        for (int i = 0; i <= endX; i++) {
            System.out.println("左 到 右 " + nums[start][i]);
        }

        // 上 到 下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.println("上 到 下 " + nums[i][endX]);
            }
        }

        // 右 到 左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.println("右 到 左 " + nums[endY][i]);
            }
        }

        // 下 到 上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                System.out.println("下 到 上 " + nums[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        ArrayList<Integer> list = printMatrixClockwisely(arr);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
        printMatrixInCircle1(arr, 3, 3, 0);
    }
}
