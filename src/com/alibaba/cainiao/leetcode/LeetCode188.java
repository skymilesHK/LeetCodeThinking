package com.alibaba.cainiao.leetcode;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 *
 * 提示：
 *
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 */
public class LeetCode188 {

    int n = 0;

    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        if (n < 2) {
            return 0;
        }

        if (k > n / 2) {
            return maxProfit2(prices);
        }

        // 表示前i天结束以后，在阶段j的最大获益
        int[][] dp = new int[n + 1][2 * k + 1 + 1];
        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = 0;
        for (int j = 2; j <= 2 * k + 1; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            // 阶段1，3，5... 是手中无股票
            for (int j = 1; j <= 2 * k + 1; j += 2) {
                // 昨天没有股票，今天继续没有
                dp[i][j] = dp[i - 1][j];
                if (j > 1 && i >= 2 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }

            // 阶段2，4...手中有股票
            for (int j = 2; j <= 2 * k + 1; j += 2) {
                // 昨天没有股票，今天买入
                dp[i][j] = dp[i - 1][j - 1];
                if (j > 1 && i >= 2 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i - 1][j - 1]);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= 2 * k + 1; i++) {
            res = Math.max(dp[n][i], res);
        }
        return res;
    }

    private int maxProfit2(int[] prices) {
        int idx = 0, res = 0;
        int valley = prices[0];
        int peak = prices[0];

        while (idx < n - 1) {
            while (idx < n - 1 && prices[idx] >= prices[idx + 1]) {
                idx++;
            }
            valley = prices[idx];
            while (idx < n - 1 && prices[idx] < prices[idx + 1]) {
                idx++;
            }
            peak = prices[idx];
            res += peak - valley;
        }

        return res;
    }

}
