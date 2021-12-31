package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 能量石 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        do {
            int idx = 1;
            int N = in.nextInt();
            Stone[] stones = new Stone[N + 1];
            int V = 0;
            for (int i = 1; i <= N; i++) {
                int s = in.nextInt(), e = in.nextInt(), l = in.nextInt();
                stones[i] = new Stone(s, e, l);
                V += s;
            }

            Arrays.sort(stones, 1, N + 1, (s1, s2) -> (s2.l * s1.s - s1.l * s2.s));

            // 从前i个能量石中选, 且吃完所有石头后时间恰好为j.(体积恰好为j)的所有选择方案, 属性：最大值能量值
            int[][] dp = new int[N + 1][V + 1];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], -0x3f3f3f3f);
            }
            dp[0][0] = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= V; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= stones[i].s) {
                        int s = stones[i].s, e = stones[i].e, l = stones[i].l;
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - s] + Math.max(0, e - (j - s) * l));
                    }
                }
            }
            int res = 0;

            for (int i = 0; i <= N; i++) {
                res = Math.max(res, dp[N][i]);
            }

            System.out.println(String.format("Case #%d: %d", idx++, res));
        } while (--T > 0);

    }

}

class Stone {
    int s;
    int e;
    int l;

    public Stone(int s, int e, int l) {
        this.s = s;
        this.e = e;
        this.l = l;
    }
}
