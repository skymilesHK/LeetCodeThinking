package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 最大上升子序列和 {
    // https://www.acwing.com/solution/content/8699/
    static int N = 1001;
    static int[] dp = new int[N];   // dp[i] 表示前i个数中的最大子序列和
    static int[] a = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = a[i];
            for (int j = 0; j < i; ++j) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}
