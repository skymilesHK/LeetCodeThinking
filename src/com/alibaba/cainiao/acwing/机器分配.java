package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 机器分配 {
    // https://www.acwing.com/video/378/
    // 分公司数N，设备台数M
    static int N = 12, M = 16;
    static int n, m;
    static int[][] v = new int[N][M];
    static int[][] w = new int[N][M];
    // 只从前i组物品中选，当前体积小于等于j的最大值
    static int[][] dp = new int[N][M];
    static int[] res = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                v[i][j] = j;
                w[i][j] = in.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 不选
                dp[i][j] = dp[i - 1][j];
                // 选i个分公司中k个机器
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i][k]] + w[i][k]);
                }
            }
        }

        System.out.println(dp[n][m]);

        //寻找当前状态dp[i][j]是从上述哪一个dp[i-1][k]状态转移过来的
        for (int i = n, j = m; i >= 1; i--) {
            for (int k = 0; k <= j; k++) {
                if (dp[i][j] == dp[i - 1][j - v[i][k]] + w[i][k]) {
                    // 第i个分公司分了k个机器
                    res[i] = k;
                    j -= k;
                    break;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d %d\n", i, res[i]);
        }
    }
}
