package com.zw.algorithms.test1;

/**
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4[IV] 和 9[IX]。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40[XL] 和 90[XC]。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400[CD] 和 900[CM]。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Test4 {
    public static void main(String[] args) {
        String s = "MDCXCV";
        System.out.println("s: " + s + ",romanToInt: " + romanToInt(s));
    }

    public static int romanToInt(String s) {
        int n = s.length();
        int roman_int = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    roman_int = roman_int + 1;
                    break;
                case 'V':
                    roman_int = roman_int + 5;
                    break;
                case 'X':
                    roman_int = roman_int + 10;
                    break;
                case 'L':
                    roman_int = roman_int + 50;
                    break;
                case 'C':
                    roman_int = roman_int + 100;
                    break;
                case 'D':
                    roman_int = roman_int + 500;
                    break;
                case 'M':
                    roman_int = roman_int + 1000;
                    break;
                default:
                    System.out.println("default");
                    break;
            }

            if (i != 0) {
                if (((s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && (s.charAt(i - 1) == 'I'))
                    roman_int = roman_int - 1 * 2;
                if (((s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && (s.charAt(i - 1) == 'X'))
                    roman_int = roman_int - 10 * 2;
                if (((s.charAt(i) == 'D') || (s.charAt(i) == 'M')) && (s.charAt(i - 1) == 'C'))
                    roman_int = roman_int - 100 * 2;
            }
        }
        return roman_int;

    }


    public static int romanToInt2(String s) {
        char[] chs = s.toCharArray();

        int res = 0;

        int n = chs.length;

        int i;

        for (i = 0; i < n - 1; ) {
            char ch1 = chs[i];
            char ch2 = chs[i + 1];

            if (ch1 == 'I' && ch2 == 'V') {
                res = 4 + res;
                i += 2;
                continue;
            }

            if (ch1 == 'I' && ch2 == 'X') {
                res = 9 + res;
                i += 2;
                continue;
            }

            if (ch1 == 'X' && ch2 == 'L') {
                res = 40 + res;
                i += 2;
                continue;
            }

            if (ch1 == 'X' && ch2 == 'C') {
                res = 90 + res;
                i += 2;
                continue;
            }

            if (ch1 == 'C' && ch2 == 'D') {
                res = 400 + res;
                i += 2;
                continue;
            }

            if (ch1 == 'C' && ch2 == 'M') {
                res = 900 + res;
                i += 2;
                continue;
            }

            switch (ch1) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }

            if (i == n - 1 - 1) {
                switch (ch2) {
                    case 'I':
                        res += 1;
                        break;
                    case 'V':
                        res += 5;
                        break;
                    case 'X':
                        res += 10;
                        break;
                    case 'L':
                        res += 50;
                        break;
                    case 'C':
                        res += 100;
                        break;
                    case 'D':
                        res += 500;
                        break;
                    case 'M':
                        res += 1000;
                        break;
                }
            }

            if (i == n - 1 - 1) break;

            i++;
        }

        if (i == n - 1) {
            switch (chs[i]) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }


        return res;
    }

    public static int romanToInt1(String s) {
        char[] chs = s.toCharArray();

        int res = 0;

        if (chs.length % 2 != 0) {
            switch (chs[chs.length - 1]) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }

        int n = chs.length - chs.length % 2;

        for (int i = 0; i < n; i = i + 1) {
            char ch1 = chs[i];
            char ch2 = chs[i + 1];

            if (ch1 == 'I' && ch2 == 'V') {
                res = 4 + res;
                continue;
            }

            if (ch1 == 'I' && ch2 == 'X') {
                res = 9 + res;
                continue;
            }

            if (ch1 == 'X' && ch2 == 'L') {
                res = 40 + res;
                continue;
            }

            if (ch1 == 'X' && ch2 == 'C') {
                res = 90 + res;
                continue;
            }

            if (ch1 == 'C' && ch2 == 'D') {
                res = 400 + res;
                continue;
            }

            if (ch1 == 'C' && ch2 == 'M') {
                res = 900 + res;
                continue;
            }

            switch (ch1) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }

            switch (ch2) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }

        }


        return res;
    }
}
