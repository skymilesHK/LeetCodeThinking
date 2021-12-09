package com.alibaba.cainiao.template;

import java.util.Scanner;

public class 蒙德里安的梦想 {
    // https://www.acwing.com/video/556/   视频
    // https://www.acwing.com/solution/content/28088/  解释
    static Scanner in = new Scanner(System.in);
    static int N = 12, M = 1 << N;
    static long[][] f = new long[N][M];
    static boolean[] st = new boolean[M];

    public static void main(String args[]) {
        int n, m;
        while (true) {
            n = in.nextInt();
            m = in.nextInt();
            if ((n | m) == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    f[i][j] = 0;
                }
            }

            for (int i = 0; i < 1 << n; i++) {
                st[i] = true;
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) != 0) {
                        if ((cnt & 1) != 0) {
                            st[i] = false;
                        }
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                if ((cnt & 1) != 0) {
                    st[i] = false;
                }
            }

            f[0][0] = 1;

            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < 1 << n; j++) {
                    for (int k = 0; k < 1 << n; k++) {
                        if ((j & k) == 0 && st[j | k]) {
                            f[i][j] += f[i - 1][k];
                        }
                    }
                }
            }
            System.out.println(f[m][0]);
        }
    }

}
