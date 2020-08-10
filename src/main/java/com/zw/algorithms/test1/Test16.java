package com.zw.algorithms.test1;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */
public class Test16 {
    public static void main(String[] args) {
        int[] digits = {4,3,2,1};
        digits = plusOne(digits);
        for (int n : digits) {
            System.out.println("digits: " + n);
        }
    }

    public static int[] plusOne(int[] digits) {
        int pre = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int n = pre + digits[i] + 1;
                digits[i] = n % 10;
                pre = n / 10;
            } else {
                int n = pre + digits[i];
                digits[i] = n % 10;
                pre = n / 10;
            }
        }
        int[] res = digits;
        if (pre != 0) {
            res = new int[digits.length + 1];
            res[0] = pre;
            System.arraycopy(digits, 0, res, 1, digits.length);
        }
        return res;
    }
}
