package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 股票买卖V {
    static int N = 10001, INF = 0x3f3f3f3f;
    static int n;
    static int[] w = new int[N];
    static int[][] dp = new int[N][3];          // 考虑前 i 天股市里面选, 且状态是j的所有选法中，价值最大值
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
        }
        dp[0][2] = 0;
        dp[0][0] = -INF;
        dp[0][1] = -INF;

        // 枚举每天的股票
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - w[i]);
            dp[i][1] = dp[i - 1][0] + w[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}
