package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 最短Hamilton路径 {

    static Scanner in = new Scanner(System.in);
    static int N = 20, M = 1 << N, INF = 0x3f3f3f3f;
    static int[][] w = new int[N][N];
    // 历史经过的点集为 state，且当前到了点 j 上的所有路径的最小值
    static int[][] dp = new int[M][N];

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[1][0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    for (int k = 0; k < n; k++) {
                        if (((i ^ (1 << j) >> k) & 1) == 1) {
                            dp[i][j] = Math.min(dp[i][j], dp[i ^ (1 << j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }

        // 为啥要-1，因为需要每一位都是1
        System.out.println(dp[(1 << n) - 1][n - 1]);
    }

}
