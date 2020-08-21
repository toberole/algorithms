package com.zw.algorithms.test2;

/**
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释:
 * 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 */
public class Test37_x {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {
        int reverse = 0;

        for (int i = 0; i < 32; i++) {
            int end = n & 1;
            n = (n >> 1); // move one bit right
            reverse = (reverse << 1); // move one bit left
            reverse |= end;
        }

        return reverse;
    }

    /**
     * 错误
     */
    public static int reverseBits1(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            int i1 = n % 2;
            char ch = (char) (i1 + '0');
            sb.append(ch);
            n = n / 2;
        }

        int len_0 = 32 - sb.length();
        for (int i = 0; i < len_0; i++) {
            sb.append('0');
        }

        System.out.println(sb.toString());

        char chs[] = sb.toString().toCharArray();
        int num = chs[0] - '0';
        int res = num;
        for (int i = 1; i < chs.length; i++) {
            num = chs[i] - '0';
            res = res * 2 + num;
        }

        System.out.println(res);

        return res;
    }


}
