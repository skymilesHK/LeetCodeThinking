package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 装箱问题 {

    // https://www.acwing.com/problem/content/1026/

    static int[][] dp = new int[31][20001];
    static int[] v = new int[31];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int V = in.nextInt();
        int N = in.nextInt();

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + v[i]);
                }
            }
        }

        System.out.println(V - dp[N][V]);
    }
}
