package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Scanner;

public class 玉米田 {
    // https://www.acwing.com/solution/content/17569/
    // https://www.acwing.com/activity/content/code/content/308038/
    static int N = 13, M = 1 << N;
    static int m, n;
    static int MOD = (int) 1e8;
    /**
     * head[i]存放下标为i的状态所能转移到的状态下标
     * 例如:
     * a: 10000001
     *
     *
     * b:
     * 1.  00101000
     * 2.  00100100
     * 所以head[10000001]={00100100,00101000}
     */
    static ArrayList<Integer>[] head = new ArrayList[1 << N];
    // state则存放所有合法的状态,如:10010和101010
    static ArrayList<Integer> states = new ArrayList<>(N);
    // dp[i][j]代表 考虑前 i 层的棋盘，且第 i 层状态是 j (j其实存储的是状态idx)的所有方案数目
    static int[][] dp = new int[N][M];
    // g[i]表示第i行能不能种植土地的状态
    static int[] g = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        m = in.nextInt();
        n = in.nextInt();

        // 枚举行/列用1 base
        for (int i = 1; i <= m; i++) {
            // 枚举二进制状态用0 base
            for (int j = 0; j < n; j++) {
                int t = in.nextInt();
                // 废土地是0，我们在这里转换为1
                g[i] += t == 1 ? 0 : (1 << j);
            }
        }

        // check每行之间不连续为1
        for (int s = 0; s < (1 << n); s++) {
            if (check(s)) {
                states.add(s);
            }
        }

        // 相邻行之间,不能相互为1
        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < states.size(); j++) {
                // i,j是状态下标，a，b是状态
                int a = states.get(i), b = states.get(j);
                if ((a & b) == 0) {
                    head[i] = head[i] == null ? new ArrayList<>() : head[i];
                    head[i].add(j);
                }
            }
        }

        // 什么也不做的时候也算一种合法方案
        dp[0][0] = 1;
        // 枚举每一行
        for (int i = 1; i <= m + 1; i++) {
            // 枚举每行下的状态。aIdx, bIdx是状态下标
            for (int bIdx = 0; bIdx < states.size(); bIdx++) {
                Integer b = states.get(bIdx);
                if ((b & g[i]) != 0) {
                    //在第i行，状态a是否满足在荒废土地没有种植玉米
                    continue;
                }
                for (Integer aIdx : head[bIdx]) {
                    dp[i][bIdx] = (dp[i][bIdx] + dp[i - 1][aIdx]) % MOD;
                }
            }
        }
        System.out.println(dp[m + 1][0]);
    }

    private static boolean check(int state) {
        for (int i = 0; i < n - 1; i++) {
            if ((state >> i & 1) == 1 && (state >> (i + 1) & 1) == 1) {
                return false;
            }
        }

        return true;
    }
}
