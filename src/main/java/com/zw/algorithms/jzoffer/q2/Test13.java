package com.zw.algorithms.jzoffer.q2;

/**
 * 剪绳子
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1]。请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少 ？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * <p>
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class Test13 {
    public static void main(String[] args) {

    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if (n <= 3) return n - 1;

        /*
            解决大问题的时候用到小问题的解并不是这三个数
            真正的dp[1] = 0,dp[2] = 1,dp[3] = 2
            但是当n=4时，4=2+2 2*2=4 而dp[2]=1是不对的也就是说当n=1/2/3时，
            分割后反而比没分割的值要小，
            当大问题用到dp[j]时，说明已经分成了一个j一个i-j，
            这两部分又可以再分，但是再分不能比他本身没分割的要小，
            如果分了更小还不如不分所以在这里指定大问题用到的dp[1],dp[2],dp[3]是他本身
        */
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[n];
    }

    /**
     * 以下数学推导总体分为两步：
     * ① 当所有绳段长度相等时，乘积最大。
     * ② 最优的绳段长度为 33 。
     * 切分规则：
     * 最优：3,把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2三种情况。
     * 次优：2,若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
     * 最差：1,若最后一段绳子长度为 1 ；则应把一份 3 + 1  替换为 2 + 2，因为 2 * 2 > 3×1。
     */
    public int cuttingRope1(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;

        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }

        return (int) Math.pow(3, a) * 2;
    }

    public int cuttingRope2(int n) {
        if (n == 2 || n == 3) return n - 1;

        int res = 1;
        while (n > 4) {
            //如果n大于4，我们不停的让他减去3
            n = n - 3;
            //计算每段的乘积
            res = res * 3;
        }
        return n * res;
    }

    /**
     * 动态规划
     * 定义一个数组dp 其中dp[i]表示的是长度为i的绳子能得到的最大乘积。我们先把长度为i的绳子拆成两部分，
     * 一部分是j，另一部分是i-j，那么会有下面4种情况:
     * 1 j和i-j都不能再拆了
     * dp[i]=j*(i-j);
     * <p>
     * 2 j能拆，i-j不能拆
     * dp[i]=dp[j]*(i-j);
     * <p>
     * 3 j不能拆，i-j能拆
     * dp[i]=j*dp[i-j];
     * <p>
     * 4 j和i-j都能拆
     * dp[i]=dp[j]*dp[i-j];
     * <p>
     * 我们取上面4种情况的最大值即可。我们把它整理一下，得到递推公式如下
     * <p>
     * dp[i] = max(dp[i], (max(j, dp[j])) * (max(i - j, dp[i - j])));
     */
    public int cuttingRope3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int i0 = Math.max(dp[i], 0);
                int i1 = Math.max(j, dp[j]);
                int i2 = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(i0, i1 * i2);
            }
        }
        return dp[n];
    }


}
