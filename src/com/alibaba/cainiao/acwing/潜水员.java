package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 潜水员 {
    // https://www.acwing.com/activity/content/code/content/387902/
    static Scanner in = new Scanner(System.in);
    static int[][][] dp = new int[1001][22][80]; //所有，从前i个气缸里面选，且氧气至少满足j，且氮气至少满足k

    public static void main(String[] args) {
        int M = in.nextInt();      //氧量
        int N = in.nextInt();      //氮量
        int K = in.nextInt();      //气缸数

        // https://www.acwing.com/file_system/file/content/whole/index/content/302744/
        // 二维情况
        //1、体积至多j，f[i,k] = 0，0 <= i <= n, 0 <= k <= m（只会求价值的最大值）
        //2、体积恰好j，
        //当求价值的最小值：f[0][0] = 0, 其余是INF
        //当求价值的最大值：f[0][0] = 0, 其余是-INF
        //3、体积至少j，f[0][0] = 0，其余是INF（只会求价值的最小值）
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 22; j++) {
                for (int k = 0; k < 80; k++) {
                    dp[i][j][k] = 0x3f3f3f3f;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 1; i <= K; i++) {
            //i气缸的氧量(费用1)
            int a = in.nextInt();
            //i气缸的氮量(费用2)
            int b = in.nextInt();
            //i气缸的重量(价值/评判标准)
            int c = in.nextInt();
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= N; k++) {
                    // 两个费用受客观条件限制，不能选择当前物品N
                    dp[i][j][k] = dp[i - 1][j][k];
                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][Math.max(0, j - a)][Math.max(0, k - b)] + c);
                }
            }
        }

        System.out.println(dp[K][M][N]);
    }

}
