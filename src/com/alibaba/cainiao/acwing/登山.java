package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 登山 {

    static int N = 1001;
    static int[] f = new int[N];
    static int[] g = new int[N];
    static int[] a = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        // 枚举a最高点求f[i]
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        // 枚举a最高点求g[i]
        for (int i = n - 1; i >= 0; i--) {
            g[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i]) {
                    g[i] = Math.max(g[i], g[j] + 1);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, f[i] + g[i] - 1);
        }
        System.out.println(res);
    }
}
