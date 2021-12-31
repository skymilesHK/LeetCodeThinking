package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 潜水员 {
    // https://www.acwing.com/solution/content/7438/    题解看仔细
    static Scanner in = new Scanner(System.in);
    static int[][][] dp = new int[1009][29][80]; //所有从前i个物品中选,且氧气含量至少是j,氮气含量至少是k的所有选法的气缸重量总和的最小值

    public static void main(String[] args) {
        // https://www.acwing.com/file_system/file/content/whole/index/content/302744/
        int M = in.nextInt();   //需要的氧气量
        int N = in.nextInt();   //需要的氮气量
        int K = in.nextInt();   //气缸分组

        for (int i = 0; i < 1009; i++) {
            for (int j = 0; j < 29; j++) {
                for (int k = 0; k < 80; k++) {
                    dp[i][j][k] = 0x3f3f3f3f;
                }
            }
        }
        dp[0][0][0] = 0;

        // 二维费用01背包
        for (int i = 1; i <= K; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int w = in.nextInt();
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= N; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][Math.max(0, j - v1)][Math.max(0, k - v2)] + w);
                }
            }
        }

        System.out.println(dp[K][M][N]);
    }

}
