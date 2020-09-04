package com.zw.algorithms.jzoffer.q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class Test1 {
    public static void main(String[] args) {
        int target = 15;
        int[][] arr = findContinuousSequence(target);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 滑动窗口
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        // 🧠里要有一个区间的概念，这里的区间是(1, 2, 3, ..., target - 1)
        // 套滑动窗口模板，l是窗口左边界，r是窗口右边界，窗口中的值一定是连续值。
        // 当窗口中数字和小于target时，r右移;
        // 大于target时，l右移;
        // 等于target时就获得了一个解
        int l = 1;
        int r = 1;
        int sum = 0;
        for (l = 1, r = 1, sum = 0; r < target; r++) {
            sum += r;

            while (sum > target) {
                sum -= l++;
            }

            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                list.add(temp);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[][] findContinuousSequence1(int target) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= target; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            int temp = i;
            for (int j = i + 1; j <= target; j++) {
                list.add(j);
                temp += j;
                if (temp > target) {
                    break;
                } else if (temp == target) {
                    res.add(list);
                    break;
                }
            }
        }

        if (res.size() > 0) {
            int size = res.size();
            int arr[][] = new int[size][];
            for (int i = 0; i < size; i++) {
                int len = res.get(i).size();
                int[] temp = new int[len];
                for (int j = 0; j < len; j++) {
                    temp[j] = res.get(i).get(j);
                }
                arr[i] = temp;
            }

            return arr;
        }
        return new int[0][0];
    }
}
