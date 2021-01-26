package com.alibaba.cainiao.leetcode;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        if (arr[0][0] == 1 || arr[m - 1][n - 1] == 1) {
            return 0;
        }
        // 到达[i,j]点，有几种路线
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    // 第一行
                    if (i == 0) {
                        dp[0][j] = arr[0][j] == 1 ? 0 : dp[0][j - 1];
                    } else {
                        // 第一列
                        dp[i][0] = arr[i][0] == 1 ? 0 : dp[i - 1][0];
                    }
                } else {
                    if (arr[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
