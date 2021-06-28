package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i]:跳到i这个下标的所有方案中，代价最小值
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return dp[n - 1];
    }
}