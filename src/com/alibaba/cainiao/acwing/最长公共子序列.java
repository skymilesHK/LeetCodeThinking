package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 最长公共子序列 {

    static int N = 1009;
    static char[] a = new char[N];
    static char[] b = new char[N];
    // dp[i][j]表示a的前i个字母，和b的前j个字母的最长公共子序列长度
    static int[][] dp = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        String sa = in.next();
        String sb = in.next();

        for (int i = 1; i <= n; i++) {
            a[i] = sa.charAt(i-1);
        }
        for (int i = 1; i <= m; i++) {
            b[i] = sb.charAt(i-1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (a[i] == b[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        System.out.println(dp[n][m]);
    }

}
