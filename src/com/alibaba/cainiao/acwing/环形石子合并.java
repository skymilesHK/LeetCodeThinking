package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 环形石子合并 {

    static int N = 201;
    static int n;
    static int INF = 0x3f3f3f3f;
    static int[] a = new int[N];
    static int[] sum = new int[N];
    static int[][] f = new int[N][N];
    static int[][] g = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            a[i + n] = a[i];
        }

        for (int i = 1; i <= n * 2; i++) {
            sum[i] = sum[i - 1] + a[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                g[i][j] = i == j ? 0 : Integer.MIN_VALUE;
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n * 2; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + sum[j] - sum[i - 1]);
                    g[i][j] = Math.max(g[i][j], g[i][k] + g[k + 1][j] + sum[j] - sum[i - 1]);
                }
            }
        }

        int minV = INF, maxV = -INF;
        for (int i = 1; i <= n; i++) {
            minV = Math.min(minV, f[i][i + n - 1]);
            maxV = Math.max(maxV, g[i][i + n - 1]);
        }

        System.out.println(minV);
        System.out.println(maxV);
    }

}
