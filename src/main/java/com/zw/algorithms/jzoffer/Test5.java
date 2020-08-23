package com.zw.algorithms.jzoffer;

/**
 * 实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Test5 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }


    public static String replaceSpace(String s) {
        char[] chars = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index++] = ch;
            }
        }
        return new String(chars);
    }


    public static String replaceSpace1(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
