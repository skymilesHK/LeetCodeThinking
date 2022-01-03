package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 方格取数 {
    // https://www.acwing.com/solution/content/51234/
    static int N = 11;
    static int[][][] dp = new int[N + N][N][N];          // 路径长度为k,第一条路线到x1=i,第二条路线到x2=j的所有方案
    static int[][] w = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        while (true) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (a == 0 || b == 0 || c == 0) {
                break;
            }
            w[a][b] = c;
        }

        for (int k = 2; k <= n + n; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1;
                    int j2 = k - i2;
                    if (j1 >= 1 && j1 <= n && j2 >= 1 && j2 <= n) {
                        // 1.下下
                        int t = w[i1][j1];
                        if(i1 != i2) {
                            t += w[i2][j2]; //若路径不重合
                        }
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2 - 1] + t);

                        // 2.下右
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2] + t);
                        // 3.右下
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1] + t);
                        // 4.右右
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2] + t);
                    }
                }
            }
        }

        System.out.println(dp[n + n][n][n]);
    }
}
