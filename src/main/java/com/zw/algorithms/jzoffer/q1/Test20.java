package com.zw.algorithms.jzoffer.q1;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Test20 {
    public static void main(String[] args) {
        int[][] matrix = {
                {
                        1, 2, 3, 4
                },
                {
                        5, 6, 7, 8
                },
                {
                        9, 10, 11, 12
                }
        };

        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

    /**
     * 循环不断地收缩矩阵的边界
     * 定义四个变量代表范围，up、down、left、right
     * 向右走存入整行的值，当存入后，该行再也不会被遍历，代表上边界的 up 加一，同时判断是否和代表下边界的 down 交错
     * 向下走存入整列的值，当存入后，该列再也不会被遍历，代表右边界的 right 减一，同时判断是否和代表左边界的 left 交错
     * 向左走存入整行的值，当存入后，该行再也不会被遍历，代表下边界的 down 减一，同时判断是否和代表上边界的 up 交错
     * 向上走存入整列的值，当存入后，该列再也不会被遍历，代表左边界的 left 加一，同时判断是否和代表右边界的 right 交错
     */
    public static int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;

        int[] res = new int[row * col];

        int index = 0;

        int left = 0;
        int top = 0;
        int right = col - 1;
        int bottom = row - 1;
        while (true) {
            //从左往右走
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }

            //从上往下走
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }

            //从右往左走
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }

            //从下往上走
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
