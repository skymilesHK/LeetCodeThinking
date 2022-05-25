package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 求组合数I {
    // https://www.acwing.com/video/306/
    static int N = 2009;
    static int MOD = (int) (1e9 + 7);
    static int[][] c = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        init();

        int n = in.nextInt();
        while (n-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(c[a][b]);
        }
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    c[i][0] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
                }
            }
        }
    }
}
