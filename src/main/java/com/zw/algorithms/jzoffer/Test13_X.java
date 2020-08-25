package com.zw.algorithms.jzoffer;

/**
 * 大数打印 打印从1到最大的n位数
 * <p>
 * 1. 表示大数的变量类型：
 * 无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应用字符串 String 类型。
 * 2. 生成数字的字符串集：
 * 使用 int 类型时，每轮可通过 +1+1 生成下个数字，而此方法无法应用至 String 类型。并且， String 类型的数字的进位操作效率较低，例如 "9999" 至 "10000" 需要从个位到千位循环判断，进位 4 次。
 * <p>
 * 观察可知，生成的列表实际上是 nn 位 00 - 99 的 全排列 ，因此可避开进位操作，通过递归生成数字的 String 列表。
 * <p>
 * 3. 递归生成全排列：
 * 基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。例如当 n = 2n=2 时（数字范围 1 - 991−99 ），固定十位为 00 - 99 ，按顺序依次开启递归，固定个位 00 - 99 ，终止递归并添加数字字符串。
 */
public class Test13_X {
    public static void main(String[] args) {
        int n = 2;
        printNumbers(n);
    }

    public static int[] printNumbers(int n) {
        StringBuffer max = new StringBuffer();
        for (int i = 0; i < n; i++) {
            max.append('9');
        }

        StringBuffer cur = new StringBuffer();
        cur.append('0');

        int pre = -1;

        while (!cur.toString().equalsIgnoreCase(max.toString())) {
            StringBuffer sb = new StringBuffer();

            for (int i = cur.length() - 1; i >= 0; i--) {
                char ch = cur.charAt(i);
                int temp = ch - '0' + pre + 1;
                pre = temp / 10;
                char cur_ch = (char) (temp % 10 + '0');
                sb.insert(0, cur_ch);
                if (pre == 0) break;
            }

            if (pre > 0) {
                sb.insert(0, (char) ('0' + 1));
            }

            if (sb.length() > 0) {
                cur.setLength(0);
                cur.append(sb);
                System.out.println(cur);
            }
        }


        return null;
    }
}
