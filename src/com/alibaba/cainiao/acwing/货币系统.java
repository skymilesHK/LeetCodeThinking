package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 货币系统 {
    // https://www.acwing.com/problem/content/1023/

    static int N, V;
    static int[] v = new int[16];
    static int[] w = new int[16];
    // 从前i个货币中选，每个货币用无限次，恰好凑满j面值的方案数
    static int[][] dp = new int[16][3001];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        N = in.nextInt();
        V = in.nextInt();
        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1 ; i <= N; ++i) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] += dp[i][j - v[i]];
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
