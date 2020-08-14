package com.zw.algorithms.test1;

/**
 * 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class Test27 {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;

        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            System.out.println(ch1);
            System.out.println(ch2);

            if ((ch1 < 'a' || ch1 > 'z') && (ch1 < '0' || ch1 > '9') ) {
                i++;
                continue;
            }

            if ((ch2 < 'a' || ch2 > 'z') && (ch2 < '0' || ch2 > '9') ) {
                j--;
                continue;
            }

            if (ch1 != ch2) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
