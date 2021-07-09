package com.zw.test1;


import com.zw.util.Util;

public class Solution1 {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] order = new int[rows * columns];
        int index = 0;

        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }

            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }

            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static int[] spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;

        int index = 0;

        int[] res = new int[(r + 1) * (b + 1)];

        while (true) {
            for (int i = l; i <= r; i++) res[index++] = matrix[t][i]; // left to right.
            if (++t > b) break;

            for (int i = t; i <= b; i++) res[index++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;

            for (int i = r; i >= l; i--) res[index++] = matrix[b][i]; // right to left.
            if (t > --b) break;

            for (int i = b; i >= t; i--) res[index++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Util.printArray(spiralOrder(matrix));
        Util.printArray(spiralOrder2(matrix));
    }
}
