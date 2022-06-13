package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 分组背包问题 {

    // https://www.acwing.com/solution/content/17559/
    static Scanner in = new Scanner(System.in);
    // 每组的物品个数s[i]
    static int[] s = new int[101];
    // 第 i 物品组的第 j 个物品的体积
    static int[][] v = new int[101][101];
    // 第 i 物品组的第 j 个物品的价值
    static int[][] w = new int[101][101];
    // 只从前i组物品中选，当前体积小于等于j的最大值
    static int[][] dp = new int[101][101];

    public static void main(String[] args) {
        // N组
        int N = in.nextInt();
        // V总容量
        int V = in.nextInt();

        for (int i = 1; i <= N; i++) {
            s[i] = in.nextInt();

            //依次读入第i组第j个物品的体积和价值
            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = in.nextInt();
                w[i][j] = in.nextInt();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                // 第i组不选
                dp[i][j] = dp[i - 1][j];

                // 选i组中第k个物品
                for (int k = 1; k <= s[i]; k++) {
                    if (j >= v[i][k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
