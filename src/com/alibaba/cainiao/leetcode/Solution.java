package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 物品
        int N = in.nextInt();
        // 容量
        int V = in.nextInt();

        // 前i个元素表示物品的体积
        int[] v = new int[N + 1];
        // 前i个元素表示物品的价值
        int[] w = new int[N + 1];
        // 前i个物品，背包容量<=j下的最优解
        int[] dp = new int[V + 1];

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        //for (int j = 0; j <= N; j++) {
        //    dp[0][j] = 0;
        //}

        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);

            }
        }

        System.out.println(dp[V]);
    }
}
