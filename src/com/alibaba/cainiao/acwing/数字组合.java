package com.alibaba.cainiao.acwing;

import java.util.Scanner;

// https://www.acwing.com/problem/content/description/280/
public class 数字组合 {
    // https://www.acwing.com/activity/content/code/content/1342266/
    static int N, M = 0;
    static Scanner in = new Scanner(System.in);
    static int[][] dp = new int[101][10001];  // 所有前i个数里面选，总和恰好为j的选法的数目

    public static void main(String[] args) {
        N = in.nextInt();
        M = in.nextInt();

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            int a = in.nextInt();
            for (int j = 0; j <= M; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= a) {
                    dp[i][j] += dp[i - 1][j - a];
                }
            }
        }

        System.out.println(dp[N][M]);
    }

}
