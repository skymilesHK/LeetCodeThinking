package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 最长公共上升子序列 {

    static Scanner in = new Scanner(System.in);
    static int N = 3009;
    static int[][] dp = new int[N][N];
    static int[] a = new int[N];
    static int[] b = new int[N];

    // dp[i][j]代表所有a[1 ~ i]和b[1 ~ j]中以b[j]结尾的公共上升子序列的集合。
    // dp[i][j]的值等于该集合的子序列中长度的最大值。
    public static void main(String[] args) {
        // 首先依据公共子序列中是否包含a[i]，将dp[i][j]所代表的集合划分成两个不重不漏的子集。
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            b[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (a[i] == b[j]) {
                    for (int k = 0; k < j; k++) {
                        if (b[k] < b[j]) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + 1);
                        }
                    }
                }
            }
        }

        //需要类似最长上升子序列求得最大值,也可以直接加到上面的循环中
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }

}
