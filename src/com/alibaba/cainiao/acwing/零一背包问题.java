package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 零一背包问题 {

    // https://www.acwing.com/problem/content/submission/code_detail/9533258/
    static Scanner in = new Scanner(System.in);

    // 朴素版本
//    public static void main(String[] args) {
//        // 物品
//        int N = in.nextInt();
//        // 容量
//        int V = in.nextInt();
//        // 前i个元素表示物品的体积
//        int[] v = new int[N + 1];
//        // 前i个元素表示物品的价值
//        int[] w = new int[N + 1];
//
//        // 前i个物品，背包容量<=j下的最优解
//        int[][] dp = new int[N + 1][V + 1];
//
//        for (int i = 1; i <= N; i++) {
//            v[i] = in.nextInt();
//            w[i] = in.nextInt();
//        }
//
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= V; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j >= v[i]) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
//                }
//            }
//        }
//
//        System.out.println(dp[N][V]);
//    }

    public static void main(String[] args) {
        // 物品
        int N = in.nextInt();
        // 容量
        int V = in.nextInt();
        // 前i个元素表示物品的体积
        int[] v = new int[N + 1];
        // 前i个元素表示物品的价值
        int[] w = new int[N + 1];

        // 表示体积为i时的最大价值
        int[] dp = new int[V + 1];

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[V]);
    }
}
