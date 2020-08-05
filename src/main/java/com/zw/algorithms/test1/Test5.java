package com.zw.algorithms.test1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 思路：最长公共字符串一定出现在最短的那一个里面
 */
public class Test5 {
    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog", "racecar", "car"};
        String s = longestCommonPrefix(strs);
        System.out.println("longestCommonPrefix: " + s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        if (strs.length == 1) return strs[0];

        String res = "";
        String tempStr = strs[0];

        for (int i = 0; i < tempStr.length(); i++) {
            char ch = tempStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j] == null || strs[j].length() <= i || strs[j].charAt(i) != ch) return res;
            }
            res += ch;
        }
        return res;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        if (strs.length == 1) return strs[0];

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 长度从小到大排序
                return o1.length() - o2.length();
            }
        });


        String res = "";
        String temp = strs[0];
        int start = 0;
        for (int end = 0; end < temp.length(); end++) {
            String s = temp.substring(start, end + 1);
            boolean b = false;
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(s)) {
                    b = true;
                    break;
                }
            }

            if (b) break;

            res = s;
        }


        return res;
    }
}
