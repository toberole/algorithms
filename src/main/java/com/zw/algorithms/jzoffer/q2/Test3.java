package com.zw.algorithms.jzoffer.q2;

/**
 * 左旋转字符串
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 */
public class Test3 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        System.out.println(reverseLeftWords(s, n));
    }

    public static String reverseLeftWords(String s, int n) {
        if (null == s || n % s.length() == 0) return s;
        StringBuffer sb = new StringBuffer();
        int k = n % s.length();

        for (int i = k; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i <k; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseLeftWords1(String s, int n) {
        if (null == s || n % s.length() == 0) return s;

        int k = n % s.length();
        char[] chs = s.toCharArray();
        for (int i = 0; i < k; i++) {
            char ch = chs[0];
            for (int j = 1; j < s.length(); j++) {
                chs[j - 1] = chs[j];
            }
            chs[s.length() - 1] = ch;
        }

        return new String(chs);
    }
}
