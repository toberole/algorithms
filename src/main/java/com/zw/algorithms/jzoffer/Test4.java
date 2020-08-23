package com.zw.algorithms.jzoffer;

/**
 * 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test4 {
    public static void main(String[] args) {
        int[][] matrix = {
                {
                        1, 2, 3, 4
                },
                {
                        5, 6, 7, 8
                }
        };

        int n = 7;
        System.out.println(findNumberIn2DArray(matrix, n));
    }

    /**
     * 从右上角开始走，利用这个顺序关系可以在O(m+n)的复杂度下解决这个题：
     * <p>
     * 如果当前位置元素比target小，则row++
     * 如果当前位置元素比target大，则col--
     * 如果相等，返回true
     * 如果越界了还没找到，说明不存在，返回false
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
