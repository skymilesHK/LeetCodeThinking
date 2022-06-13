package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 多重背包问题I {
    // https://www.acwing.com/video/216/
    static Scanner in = new Scanner(System.in);
    static int N, V = 0;
    static int[][] dp = new int[109][109];
    static int[] v = new int[109];
    static int[] w = new int[109];
    static int[] s = new int[109];

    public static void main(String[] args) {
        N = in.nextInt();
        V = in.nextInt();
        //输入物品
        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k <= s[i]; k++) {
                    if (j >= k * v[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                    }
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
