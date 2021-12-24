package com.alibaba.cainiao.acwing;

import java.util.Scanner;

// https://www.acwing.com/activity/content/code/content/557835/
public class 混合背包 {
    static int[][] dp = new int[1010][1010];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        //可怜的我不想优化
        for (int i = 1; i <= n; i++) {
            int v = in.nextInt(), w = in.nextInt(), s = in.nextInt();
            if (s == 0) {
                s = 1010;
            }
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + w);
                }
                for (int k = 2; k <= s; k++) {
                    if (j - k * v < 0) {
                        break;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v] + k * w);
                }
            }
        }
        System.out.print(dp[n][m]);
    }

}
