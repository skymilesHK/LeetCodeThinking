package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 宠物小精灵之收服 {

    static int N, M, K;
    // 表示所有从前i个小精灵里面选，且费用1精灵球数量不超过j，且费用2消耗皮卡丘体力为k的情况下的选法集合
    static int[][][] dp;
    // 精灵球初始数量, 条件1
    static int[] v1;
    // 皮卡丘初始的体力值, 条件2
    static int[] v2;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // 精灵球数量,条件1
        N = in.nextInt();
        // 皮卡丘初始的体力值,条件2
        M = in.nextInt();
        // 野生小精灵的数量
        K = in.nextInt();
        v1 = new int[K + 1];
        v2 = new int[K + 1];

        dp = new int[K + 1][N + 1][M + 1];
        for (int i = 1; i <= K; i++) {
            v1[i] = in.nextInt();
            v2[i] = in.nextInt();
        }

        // 表示所有从前i个小精灵里面选
        for (int i = 1; i <= K; i++) {
            // 费用1精灵球数量不超过j
            for (int j = 0; j <= N; j++) {
                // 注意是M - 1,因为皮卡丘体力值不能消耗全部M，要留1点体力
                for (int k = 0; k <= M - 1; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= v1[i] && k >= v2[i]) {
                        // 这题的价值是精灵的数量，所以就是每一次选上的情况就加1
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - v1[i]][k - v2[i]] + 1);
                    }
                }
            }
        }

        // 找到满足最大价值的所有状态里，第二维费用消耗最少的（皮卡丘最小消耗体力）
        int hp = M;
        for (int i = 0; i <= M - 1; i++) {
            if (dp[K][N][i] == dp[K][N][M - 1]) {
                hp = Math.min(hp, i);
            }
        }

        System.out.println(dp[K][N][M - 1] + " " + (M - hp));
    }
}
