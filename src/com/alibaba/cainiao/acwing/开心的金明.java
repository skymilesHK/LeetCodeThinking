package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 开心的金明 {

    // https://www.acwing.com/solution/content/54006/
    static int N, V = 0;
    static int[] v = new int[29];
    static int[] w = new int[29];
    // dp[i,j]：前i个物品中选v*w的最大和
    static int[][] dp = new int[29][30009];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        V = in.nextInt();
        N = in.nextInt();

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + v[i] * w[i]);
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
