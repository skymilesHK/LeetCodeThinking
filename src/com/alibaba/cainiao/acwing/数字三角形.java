package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 数字三角形 {

    // https://www.acwing.com/solution/content/59764/
    static int N = 509;
    // 从最底层出发到第 i 行第 j 个数的最大路径和
    static int[][] dp = new int[N][N];
    static int[][] g = new int[N][N];
    static Scanner in = new Scanner(System.in);

    // 7
    // 3   8
    // 8   1   0
    // 2   7   4   4
    // 4   5   2   6   5
    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i][j] = in.nextInt();
            }
        }

        for (int i = n; i >= 1; i--) {
            //从最后一排开始走，从下往上。
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j + 1], dp[i + 1][j]) + g[i][j];
            }
        }

        System.out.println(dp[1][1]);
    }
}
