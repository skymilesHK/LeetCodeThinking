package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 庆功会 {

    static Scanner in = new Scanner(System.in);
    static int N, V = 0;
    static int[][] dp = new int[501][6001];
    static int[] v = new int[101];
    static int[] w = new int[1001];
    static int[] s = new int[11];

    public static void main(String[] args) {
        N = in.nextInt();
        V = in.nextInt();

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }

        System.out.println(dp[N][V]);
    }

}
