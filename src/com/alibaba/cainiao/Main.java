package com.alibaba.cainiao;

import java.util.Scanner;

public class Main {

    static int M = 109;
    static int N, V = 0;
    static int[] v = new int[M];
    static int[] w = new int[M];
    static int[] s = new int[M];
    static int[][] dp = new int[M][M];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // https://www.acwing.com/solution/content/5430/
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
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + w[i] * k);
                }
            }
        }

        System.out.println(dp[N][V]);
    }

}