package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 蒙德里安的梦想 {
    // https://www.acwing.com/video/556/   视频
    // https://www.acwing.com/solution/content/28088/  解释
    // https://www.acwing.com/solution/content/6103/   代码
    static Scanner in = new Scanner(System.in);
    static int N = 12, M = 1 << N;
    // 表示已经将前i-1列摆好，且从第i-1列伸出到第i列，状态是j的所有方案
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

            // reset
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    f[i][j] = 0;
                }
            }

            // 第一部分：预处理1
            // 对于每种状态，先预处理每列不能有奇数个连续的0
            // 枚举每个状态(1 << n就是一个状态)
            for (int i = 0; i < 1 << n; i++) {
                st[i] = true;
                // 连续的0个数
                int cnt = 0;
                // 每行
                for (int j = 0; j < n; j++) {
                    // i >> j位运算，表示i（i在此处是一种状态）的二进制数的第j位
                    if ((i >> j & 1) != 0) {
                        // 连续的0奇数个
                        if ((cnt & 1) != 0) {
                            st[i] = false;
                        }
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                // https://www.acwing.com/video/556/  大树101 的回答
                if ((cnt & 1) != 0) {
                    st[i] = false;
                }
            }

            f = new long[N][M];
            f[0][0] = 1;

            // 对于每一列
            for (int i = 1; i <= m; i++) {
                // 枚举每个状态
                for (int j = 0; j < 1 << n; j++) {
                    for (int k = 0; k < 1 << n; k++) {
                        if ((j & k) == 0 && st[j | k]) {
                            //第i-2列伸出来的 和第i-1列伸出来的不冲突(不在同一行)
                            //解释一下st[j | k]
                            //已经知道st[]数组表示的是这一列没有连续奇数个0的情况，
                            //我们要考虑的是第i-1列（第i-1列是这里的主体）中从第i-2列横插过来的，
                            //还要考虑自己这一列（i-1列）横插到第i列的
                            //比如 第i-2列插过来的是k=10101，第i-1列插出去到第i列的是 j =01000，
                            //那么合在第i-1列，到底有多少个1呢？
                            //自然想到的就是这两个操作共同的结果：两个状态或。 j | k = 01000 | 10101 = 11101
                            //这个 j|k 就是当前 第i-1列的到底有几个1，即哪几行是横着放格子的

                            f[i][j] += f[i - 1][k];
                        }
                    }
                }
            }
            System.out.println(f[m][0]);
        }
    }

}
