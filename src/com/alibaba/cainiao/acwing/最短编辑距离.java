package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 最短编辑距离 {

    // https://www.acwing.com/solution/content/7141/

    static int N = 1009;
    static char[] a = new char[N];
    static char[] b = new char[N];
    // 所有把a中的前i个字母 变成 b中前j个字母的操作集合
    static int[][] dp = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        String sa = in.next();
        int m = in.nextInt();
        String sb = in.next();
        for (int i = 1; i <= n; i++) {
            a[i] = sa.charAt(i - 1);
        }
        for (int i = 1; i <= m; i++) {
            b[i] = sb.charAt(i - 1);
        }

        for (int i = 0; i <= n; i++) {
            //若a长度为i，b长度为0，则需要进行i次删除操作
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            //若a长度为0，b长度为i，则需要进行i次添加操作
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 添加和删除
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                // 修改,两种情况
                if (a[i] == b[j]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
