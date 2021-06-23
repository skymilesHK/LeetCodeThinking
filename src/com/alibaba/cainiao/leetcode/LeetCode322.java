package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class LeetCode322 {
    // https://www.acwing.com/video/1709/ 代码
    // https://www.acwing.com/video/945/  完全背包
    // 完全背包，n个硬币（无限个），每个硬币有各个体积，amount是背包大小，问所需的最少的硬币个数
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //用前i个物品 ，装进体积为j 的所有方案的集合的最小值
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }

        return dp[n][amount] >= 0x3f3f3f3f ? -1 : dp[n][amount];
    }
}
