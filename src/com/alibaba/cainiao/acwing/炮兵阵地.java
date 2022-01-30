package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Scanner;

public class 炮兵阵地 {
    // 不使用滚动数组优化
    static int n, m;
    static ArrayList<Integer> states = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        //预处理地图
        int[] g = new int[n + 3];
        for (int i = 1; i <= n; i++) {
            String s = in.next();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'H') {
                    g[i] += 1 << j;
                }
            }
        }
        //预处理所有的合法状态和状态中1的个数
        int[] cnt = new int[1 << m];
        for (int i = 0; i < 1 << m; i++) {
            if (check(i)) {
                states.add(i);
                cnt[i] = count(i);
            }
        }
        //计算状态转移值
        int[][][] dp = new int[n + 3][states.size()][states.size()];
        for (int i = 1; i <= n + 2; i++) {
            for (int j = 0; j < states.size(); j++) {
                for (int k = 0; k < states.size(); k++) {
                    for (int u = 0; u < states.size(); u++) {
                        int a = states.get(j);
                        int b = states.get(k);
                        int c = states.get(u);
                        if ((a & b) != 0 || (a & c) != 0 || (b & c) != 0) {
                            continue;
                        }
                        if ((g[i] & a) != 0 || (g[i - 1] & b) != 0) {
                            continue;
                        }
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][k][u] + cnt[a]);
                    }
                }
            }
        }
        System.out.println(dp[n + 2][0][0]);
    }

    private static boolean check(int a) {
        for (int i = 0; i < m; i++) {
            if ((a >> i & 1) == 1 && ((a >> i + 1 & 1) == 1 || (a >> i + 2 & 1) == 1)) {
                return false;
            }
        }
        return true;
    }

    private static int count(int a) {
        int res = 0;
        for (int i = 0; i < m; i++) {
            res += a >> i & 1;
        }
        return res;
    }

}
