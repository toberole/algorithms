package com.zw.algorithms.test1;

/**
 * 最后一个单词的长度
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串
 */
public class Test15 {
    public static void main(String[] args) {
        String s = "b   a    ";
        int len = lengthOfLastWord(s);
        System.out.println(len);
    }

    /**
     * 从字符串末尾开始向前遍历，其中主要有两种情况
     * 第一种情况，以字符串"Hello World"为例，从后向前遍历直到遍历到头或者遇到空格为止，即为最后一个单词"World"的长度5
     * 第二种情况，以字符串"Hello World "为例，需要先将末尾的空格过滤掉，再进行第一种情况的操作，即认为最后一个单词为"World"，长度为5
     * 所以完整过程为先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度
     * 时间复杂度：O(n)，n为结尾空格和结尾单词总体长度
     */
    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public static int lengthOfLastWord1(String s) {
        if (s == null || s.trim().length() == 0) return 0;

        int pre_n = 0;
        int n = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                n++;
            } else {
                if (n != 0) {
                    pre_n = n;
                    n = 0;
                }
            }
        }

        if (n != 0) return n;

        return pre_n;
    }
}
