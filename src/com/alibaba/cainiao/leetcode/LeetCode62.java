package com.alibaba.cainiao.leetcode;

/**
 * Unique Paths
 * 问总共有多少条不同的路径？
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        // 到达[i,j]点，有几种路线
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
