package com.alibaba.cainiao.acwing;

import java.math.BigInteger;
import java.util.Scanner;

public class 凸多边形的划分 {
    // https://www.acwing.com/video/408/

    static int N = 51, INF = 0x3f3f3f3f, n;
    static BigInteger[] w = new BigInteger[N];
    static BigInteger[][] dp = new BigInteger[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = BigInteger.valueOf(in.nextInt());
        }

        // 不足三个点无法构成三角形
        for (int len = 1; len < 3; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                dp[l][r] = BigInteger.valueOf(0);
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                dp[l][r] = BigInteger.valueOf(INF);
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = dp[l][r].min(dp[l][k].add(dp[k][r]).add(w[l].multiply(w[k]).multiply(w[r])));
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
