package com.alibaba.cainiao.leetcode;

public class LeetCode312 {
    // 超级难
    public int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int arr[] = new int[len + 2];
        arr[0] = 1;
        arr[len + 1] = 1;
        for (int i = 1; i <= len; ++i) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[len + 2][len + 2];
        for (int l = 1; l <= len; ++l) {
            for (int i = 1; i <= len - (l - 1); ++i) {
                int j = i + l - 1;
                // k是最后一个打破的气球的值
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j+1]);
                }
            }
        }
        return dp[1][len];
    }
}
