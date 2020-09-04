package com.zw.algorithms.jzoffer.q2;

/**
 * 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    /**
     * 双指针
     * 算法解析：
     * 倒序遍历字符串 ss ，记录单词左右索引边界 ii , jj ；
     * 每确定一个单词的边界，则将其添加至单词列表 resres ；
     * 最终，将单词列表拼接为字符串，并返回即可。
     * 复杂度分析：
     * 时间复杂度 O(N)O(N) ： 其中 NN 为字符串 ss 的长度，线性遍历字符串。
     * 空间复杂度 O(N)O(N) ： 新建的 list(Python) 或 StringBuilder(Java) 中的字符串总长度 \leq N≤N ，占用 O(N)O(N) 大小的额外空间。
     */
    public static String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }


    public static String reverseWords1(String s) {
        if (s == null || s.trim().length() == 1) return s.trim();
        s = s.trim();
        int len = s.length();

        StringBuffer sb = new StringBuffer();
        int index = 0;
        boolean b = false;
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                b = false;
                sb.insert(index, ch);
            } else {
                if (!b) {
                    sb.append(' ');
                    b = true;
                }

                index = sb.length();
            }
        }

        return sb.toString();
    }
}
