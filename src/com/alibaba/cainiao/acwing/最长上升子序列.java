package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 最长上升子序列 {

    static int N = 1009;
    // 以i结尾的各种上升子序列集合中，最长的长度数值
    static int[] dp = new int[N];
    static int[] a = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        // 子序列的长度最长值
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

        System.out.println(res);
    }
}
