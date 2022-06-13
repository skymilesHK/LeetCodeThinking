package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 整数划分 {

    // https://www.acwing.com/solution/content/18446/

    static int N = 1009;
    static final int mod = (int) (1e9 + 7);
    // 完全背包
    static int[][] dp = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 容量为0时，前 i 个物品全不选也是一种方案
            dp[i][0] = 1;
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] % mod;
                if (j >= i) {
                    dp[i][j] = (dp[i][j] + dp[i][j - i]) % mod;
                }
            }
        }

        System.out.println(dp[n][n]);
    }

}
