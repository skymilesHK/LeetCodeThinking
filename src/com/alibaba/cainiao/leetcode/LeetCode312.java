package com.alibaba.cainiao.leetcode;

public class LeetCode312 {
    // 超级难
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int arr[] = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i <= n; ++i) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n + 2; len++) {
            for (int i = 0; i + len - 1 <= n + 1; i++) {
                int j = i + len - 1;
                // k是最后一个打破的气球的值(i,j)之前的取值,边界不能戳破
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
