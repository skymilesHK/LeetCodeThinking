package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 机器分配 {
    // https://www.acwing.com/problem/content/description/1015/

    static int N = 12, M = 18;  // 分公司数N，设备台数M；
    static int n, m;
    static int[][] v = new int[N][M];
    static int[][] w = new int[N][M];
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
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];  //不选
                for (int k = 1; k <= j; k++) {
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
