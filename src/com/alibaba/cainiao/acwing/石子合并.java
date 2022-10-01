package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 石子合并 {

    // https://www.acwing.com/video/943/

    static Scanner in = new Scanner(System.in);
    static int N = 302, n = 0;
    // dp[i][j]表示将 i 到 j 这一段石子合并成一堆的方案的集合，属性 Min
    static int[][] dp = new int[N][N];
    static int[] sum = new int[N];
    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            sum[i] = in.nextInt();
            sum[i] = sum[i] + sum[i - 1];
        }

        // 区间dp一般第一层枚举区间长度
        for (int len = 2; len <= n; len++) {
            // 起点
            for (int i = 1; i + len - 1 <= n; i++) {
                // 终点
                int j = i + len - 1;
                dp[i][j] = INF;
                //  分割区间的点, 这里k不能等于j,因为要保留区间要有一堆石子
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                }
            }
        }

        System.out.println(dp[1][n]);
    }

}
