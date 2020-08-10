package com.zw.algorithms.test1;

/**
 * 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */
public class Test17 {


    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int pre = 0;
        while (i >= 0 && j >= 0) {
            char ch_a = a.charAt(i);
            char ch_b = b.charAt(j);

            int data_a = ch_a - '0';
            int data_b = ch_b - '0';

            int n = data_a + data_b + pre;

            int data = n % 2;
            pre = n / 2;

            char ch = (char) (data + '0');
            sb.insert(0, ch);

            i--;
            j--;
        }


        while (i >= 0) {
            char ch = a.charAt(i);
            int n = ch - '0' + pre;
            pre = n / 2;
            int data = n % 2;
            char res = (char) (data + '0');
            sb.insert(0, res);
            i--;
        }

        while (j >= 0) {
            char ch = b.charAt(j);
            int data_ch = ch - '0';
            int data = (pre + data_ch) % 2;
            pre = (pre + data_ch) / 2;
            sb.insert(0, (char) (data + '0'));

            j--;
        }

        if (pre > 0) {
            sb.insert(0, (char) (pre + '0'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String s = addBinary(a, b);
        System.out.println(s);
    }
}
