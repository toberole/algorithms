package com.zw.algorithms.test4;

import com.zw.algorithms.bean.TreeNode;
import com.zw.util.Util;

import java.util.*;

import static jdk.nashorn.internal.objects.Global.print;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = q.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    q.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    q.add(treeNode.right);
                }
            }

            res.add(temp);
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null) return null;

        int rows = matrix.length;
        int cols = matrix[0].length;
        if (cols <= 0) return null;

        List<Integer> res = new ArrayList<>();
        int start = 0;
        while (rows > 2 * start && cols > 2 * start) {
            printEle(res, start, matrix, rows, cols);
            start++;
        }

        int size = res.size();
        System.out.println(size);
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    private static void printEle(List<Integer> res, int start, int[][] matrix, int rows, int cols) {
        int endX = cols - start - 1;
        int endY = rows - start - 1;

        System.out.println("endX: " + endX + ",endY: " + endY);

        // 从左到右
        if (start < endX) {
            for (int i = start; i <= endX; i++) {
                res.add(matrix[start][i]);
            }
        }

        // 从上到下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                res.add(matrix[endX][i]);
            }
        }

        // 从右到左
        if (start < endX && endY < start) {
            for (int i = endX - 1; i >= start; i--) {
                res.add(matrix[endY][i]);
            }
        }

        // 从下到上
        if (start < endX && endY < start - 1) {
            for (int i = endY - 1; i >= start - 1; i--) {
                res.add(matrix[start][i]);
            }
        }
    }

    public int[] printMatrixClockwisely(int[][] nums) {
        if (nums == null) return null;

        ArrayList<Integer> list = new ArrayList<Integer>();

        int rows = nums.length;
        int cols = nums[0].length;

        if (cols <= 0 || rows <= 0) return null;

        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            printMatrixInCircle(list, nums, cols, rows, start);
            ++start;
        }
        int size = list.size();

        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    private void printMatrixInCircle(ArrayList<Integer> list, int[][] nums,
                                     int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;


        for (int i = start; i <= endX; ++i) {
            int number = nums[start][i];
            list.add(number);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                int number = nums[i][endX];
                list.add(number);
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                int number = nums[endY][i];
                list.add(number);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                int number = nums[i][start];
                list.add(number);
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Hello World!");
        Util.printArray(spiralOrder(arr));
    }

}
