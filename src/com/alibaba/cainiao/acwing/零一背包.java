package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 零一背包 {

    // https://www.acwing.com/solution/content/30250/

    static Scanner in = new Scanner(System.in);
    // 前i个元素表示物品的体积
    static int[] v = new int[1001];
    // 前i个元素表示物品的价值
    static int[] w = new int[1001];
    // 所有选法集合中,只从前i个物品中选,并且总体积≤≤j的选法的集合,它的值是这个集合中每一个选法的最大值
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) {
        // 物品
        int N = in.nextInt();
        // 容量，升 的英文
        int V = in.nextInt();

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                // 不选
                dp[i][j] = dp[i - 1][j];
                // 选
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(dp[N][V]);
    }

}
