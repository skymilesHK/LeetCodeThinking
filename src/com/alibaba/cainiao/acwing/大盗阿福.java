package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 大盗阿福 {

    static int N = 100001;
    static int[][] dp = new int[N][2];          // 考虑前 i 家店铺，当前第 i 家店铺选择 偷(j=1) 或者 不偷(j=0) 的所有方案的集合。集合属性：价值Max
    static int[] w = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        do {
            solve();
        } while (--T > 0);
    }

    private static void solve() {
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
        }

        dp[0][0] = 0;
        dp[0][1] = -0x3f3f3f3f;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + w[i];
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }

}
