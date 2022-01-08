package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 拦截导弹 {

    // https://www.acwing.com/solution/content/8239/
    static int N = 1001;
    static int[] dp = new int[N];
    static int[] g = new int[N];
    static int[] a = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        while (in.hasNext()) {
            a[cnt++] = in.nextInt();
        }
        int res = 1;
        for (int i = 0; i < cnt; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (a[j] >= a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        int idx = 0;    // 第一个可用的g数组的下标
        for (int i = 0; i < cnt; ++i) {
            int k = 0;
            while (k < idx && g[k] < a[i]) {
                k++;
            }
            g[k] = a[i];
            if (k >= idx) {
                idx++;
            }
        }

        System.out.println(res);
        System.out.println(idx);

    }

}
