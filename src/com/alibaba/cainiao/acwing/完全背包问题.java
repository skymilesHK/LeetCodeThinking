package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 完全背包问题 {

//    // https://www.acwing.com/problem/content/3/
//    static Scanner in = new Scanner(System.in);
//    // 前i个元素表示物品的体积
//    static int[] v = new int[1001];
//    // 前i个元素表示物品的价值
//    static int[] w = new int[1001];
//    // 所有选法集合中,只从前i个物品中选,并且总体积≤≤j的选法的集合, 这个集合中每一个选法的最大值
//    static int[][] dp = new int[1001][1001];
//
//    public static void main(String[] args) {
//        int N = in.nextInt();
//        int V = in.nextInt();
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
//                    dp[i][j] = Math.max(dp[i][j], dp[i][j - v[i]] + w[i]);
//                }
//            }
//        }
//
//        System.out.println(dp[N][V]);
//    }

    // https://www.acwing.com/problem/content/3/
    static Scanner in = new Scanner(System.in);
    // 前i个元素表示物品的体积
    static int[] v = new int[1001];
    // 前i个元素表示物品的价值
    static int[] w = new int[1001];
    // 所有选法集合中,只从前i个物品中选,并且总体积≤≤j的选法的集合, 这个集合中每一个选法的最大值
    static int[] dp = new int[1001];

    public static void main(String[] args) {
        int N = in.nextInt();
        int V = in.nextInt();

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        System.out.println(dp[V]);
    }
}
