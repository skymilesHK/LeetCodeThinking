package com.alibaba.cainiao.leetcode;

/**
 * 买卖股票的最佳时机 II
 * 122. Best Time to Buy and Sell Stock II
 * Easy
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e., max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 */
public class LeetCode122 {

    // 九章动态规划-序列型

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        // dp[i][j]表示前i天结束后，在阶段j的最大获利
        int[][] dp = new int[n + 1][5 + 1];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int j = 2; j <= 5; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            // 阶段1，3，5 是手中无股票
            for (int j = 1; j <= 5; j += 2) {
                // 前一天就处于这阶段
                dp[i][j] = dp[i - 1][j];
                if (i >= 2 && j >= 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }

            // 阶段2，4
            for (int j = 2; j <= 5; j += 2) {
                // 前一天就处于前一个阶段，没有收益
                dp[i][j] = dp[i - 1][j - 1];
                if (i >= 2 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }

        return Math.max(Math.max(dp[n][1], dp[n][3]), dp[n][5]);
    }
}
