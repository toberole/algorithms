package com.zw.algorithms.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Test23 {
    public static void main(String[] args) {
        int numRows = 2;
        List<List<Integer>> res = generate(numRows);

        printRes(res);
    }

    private static void printRes(List<List<Integer>> res) {
        if (res == null || res.size() == 0) return;

        StringBuffer sb = new StringBuffer();
        for (List<Integer> line : res) {
            for (Integer i : line) {
                sb.append(i + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 1) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            res.add(line);
        }

        if (numRows == 2) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            res.add(line);

            line = new ArrayList<>();
            line.add(1);
            line.add(1);
            res.add(line);
        }

        if (numRows<=2)return res;


        List<Integer> line = new ArrayList<>();
        line.add(1);
        res.add(line);

        line = new ArrayList<>();
        line.add(1);
        line.add(1);
        res.add(line);

        for (int i = 3; i <= numRows; i++) {
            List<Integer> pre_line = res.get((i - 1) - 1);
            List<Integer> cur_line = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    cur_line.add(1);
                } else if (j == i - 1) {
                    cur_line.add(1);
                } else {
                    int n = pre_line.get(j - 1) + pre_line.get(j);
                    cur_line.add(n);
                }
            }

            res.add(cur_line);
        }

        return res;
    }
}
