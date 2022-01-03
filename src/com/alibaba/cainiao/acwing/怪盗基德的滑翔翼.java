package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 怪盗基德的滑翔翼 {
    // https://www.acwing.com/solution/content/51431/
    static int N = 101;
    static int[] dp = new int[N];
    static int[] a = new int[N];
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int k = in.nextInt();
        do {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            // 正向LIS
            int res = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            // 返向LIS
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = 1;
                for (int j = n - 1; j >= i; j--) {
                    if (a[j] < a[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }

            System.out.println(res);
        } while (--k > 0);
    }
}
