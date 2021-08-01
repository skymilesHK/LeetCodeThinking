package com.alibaba.cainiao.leetcode;

/**
 * 123. Best Time to Buy and Sell Stock III
 * Hard
 *
 * 3743
 *
 * 92
 *
 * Add to List
 *
 * Share
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
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
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Example 4:
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 */
public class LeetCode123 {
    // 九章序列型
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        // 表示前i天结束以后，在阶段j的最大获益
        int[][] dp = new int[n + 1][5 + 1];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int j = 2; j <= 5; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }

        // 枚举每天
        for (int i = 1; i <= n; i++) {
            // 阶段1，3，5 是手中无股票
            for (int j = 1; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j];
                if (i - 2 >= 0 && j >= 2 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }

            // 阶段2，4手中有股票
            for (int j = 2; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];
                if (i - 2 >= 0 && j >= 1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i][j]);
                }
            }
        }

        return Math.max(Math.max(dp[n][1], dp[n][3]), dp[n][5]);
    }
}
