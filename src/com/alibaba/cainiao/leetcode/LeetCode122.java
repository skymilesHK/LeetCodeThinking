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

    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
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
