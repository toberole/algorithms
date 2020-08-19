package com.zw.algorithms.test1;

/**
 * Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 * <p>
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 * <p>
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 */
public class Test33 {
    public static void main(String[] args) {
        int n = 52;
        System.out.println(convertToTitle(n));
    }

    /**
     * 类似与 10进制数据转换为26进制[注意没有0]
     *
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        if (n <= 0) return "";

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
