package com.zw.algorithms.test1;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 */
public class Test {
    public static void main(String[] args) {
        String num1 = "3876620623801494171";
        String num2 = "6529364523802684779";
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        System.out.println("num1 + num2: " + addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int pre = 0;
        while (i >= 0 || j >= 0 || pre != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int temp = n1 + n2 + pre;
            pre = temp / 10;
            char ch = (char) (temp % 10 + '0');
            sb.insert(0, ch);
            i--;
            j--;
        }

        return sb.toString();
    }

}
