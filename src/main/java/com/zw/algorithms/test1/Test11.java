package com.zw.algorithms.test1;

/**
 * 实现strStr()函数
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * <p>
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。
 * 这与C语言的strstr()以及 Java的indexOf()定义相符。
 */
public class Test11 {
    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if (haystack == null || haystack.length() == 0) return -1;

        int haystack_len = haystack.length();
        int needle_len = needle.length();
        for (int i = 0; i <= haystack_len - needle_len; i++) {
            int index = -1;
            for (int j = 0; j < needle_len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    index = -1;
                    break;
                } else {
                    index = i;
                }
            }

            if (index != -1) return index;
        }

        return -1;
    }
}
