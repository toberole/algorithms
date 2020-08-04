package com.zw.algorithms.test1;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class Test2 {
    public static void main(String[] args) {
        int num = 210;
        int ret = reverse(num);
        System.out.println("num: " + num + ",ret: " + ret);
    }

    public static int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int t = ret * 10;

            if (t / 10 != ret) return 0;

            ret = t + x % 10;
            x /= 10;
        }
        return ret;
    }

    public static int reverse3(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

        // long ---> int 如果转换前后结果一样 则说明没有发生溢出 技巧
        return (int) n == n ? (int) n : 0;
    }

    public static int reverse2(int x) {
        //int的最大值最小值
        int max = 0x7fffffff;
        int min = 0x80000000;

        //用long类型判断溢出
        long rs = 0;
        //逆序，正负通吃，不用单独考虑负值
        for (; x != 0; rs = rs * 10 + x % 10, x /= 10) ;

        //超了最大值低于最小值就返回0
        return rs > max || rs < min ? 0 : (int) rs;
    }

    public static int reverse1(int x) {
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) return 0;

        if (x < 10 && x >= 0) return x;

        int temp = Math.abs(x);


        long ret = 1;
        int k = 0;

        while (temp / 10 != 0) {
            int num = temp % 10;

            if (k == 0) {
                ret = num;
            } else {
                ret = ret * 10 + num;
            }

            k++;
            temp = temp / 10;
        }

        if (temp != 0) {
            ret = temp + ret * 10;
        }


        if (x > 0) {
            return (int) ret;
        } else {
            return (int) (-1 * ret);
        }
    }

}
