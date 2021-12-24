package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 货币系统NOIP {

    static int N = 110;
    static int M = 25010;
    static int[] V = new int[N];
    static int[][] dp = new int[N][M];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int cnt = cin.nextInt();

        while (cnt-- != 0) {
            int n = cin.nextInt();

            for (int i = 1; i <= n; i++) {
                V[i] = cin.nextInt();
            }
            Arrays.sort(V, 1, n + 1);
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= V[n]; j++) {
                    dp[i][j] = 0;
                }
            }
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= V[n]; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= V[i]) {
                        dp[i][j] += dp[i][j - V[i]];
                    }
                }
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (dp[i - 1][V[i]] == 0) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

}
