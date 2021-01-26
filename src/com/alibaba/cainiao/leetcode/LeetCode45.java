package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

public class LeetCode45 {
    // 输入: [2,3,1,1,4]
    // 输出: 2
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 0x3f3f3f);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // j点跳过来
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }

        return dp[n - 1];
    }

}
