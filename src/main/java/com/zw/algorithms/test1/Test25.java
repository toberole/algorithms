package com.zw.algorithms.test1;

/**
 * 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 */
public class Test25 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    /**
     * DP动态规划思想：
     * <p>
     * 记录【今天之前买入的最小值】
     * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     * 比较【每天的最大获利】，取最大值即可
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int in = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int out = prices[j];
                int t = out - in;
                if (t > max) {
                    max = t;
                }
            }
        }
        return max;
    }
}
