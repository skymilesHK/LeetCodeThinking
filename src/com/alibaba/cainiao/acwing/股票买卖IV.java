package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 股票买卖IV {
    static int N = 100002, K = 102, INF = 0x3f3f3f3f;
    static int n, k;
    static int[] w = new int[N];
    static int[][][] dp = new int[N][K][2];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // https://www.acwing.com/activity/content/code/content/329461/  必看
        // 状态表示：f[i][j][k]：从前i天中选，且经过j次交易，且当前状态为k（0无货，1有货）的集合。的最大值
        // dp[i][j][0]：走到第i天，且已经进行了j次交易，且手中无货
        // dp[i][j][1]：走到第i天，且正在进行第j次交易，且手中有货
        n = in.nextInt();
        k = in.nextInt();

        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
        }

        // init
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -INF);
            }
        }
        dp[0][0][0] = 0;

        // 枚举每天的股票
        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = 0;
            // 枚举每个交易
            for (int j = 0; j <= k; j++) {
                if (j >= 1) {
                    // 无股票状态。卖出股票为标志计为一次交易
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + w[i]);
                }
                // 有股票状态
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][1] - w[i]);
            }
        }

        int res = 0;
        for (int j = 0; j <= k; j++) {
            res = Math.max(res, dp[n][j][0]);
        }
        System.out.println(res);
    }
}
