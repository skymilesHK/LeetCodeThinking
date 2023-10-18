package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 买书 {
    // https://www.acwing.com/solution/content/108561/
    static int N = 5, M = 1009;
    static int n = 4, m = 0;
    static int[] v = {0, 10, 20, 50, 100};
    static int[][] dp = new int[N][M];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // n元钱全部用来买书，书的价格为10元，20元，50元，100元
        m = in.nextInt();

        //dp
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; v[i] * k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - v[i] * k];
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
