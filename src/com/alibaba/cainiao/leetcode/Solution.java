package com.alibaba.cainiao.leetcode;

import com.alibaba.cainiao.Main;

import java.util.*;

public class Solution {

    static int N = 501;
    static int n, m = 0;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], 0x3f3f3f3f);
        }

        do {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            g[a][b] = Math.min(g[a][b], c);
            g[b][a] = Math.min(g[b][a], c);
        } while (--m > 0);

        int res = prim();
        if (res >= 0x3f3f3f3f) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }

    private static int prim() {
        int res = 0;
        // 1. 初始化距离
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        // 2. 进行n（n为n的个数）次迭代去确定每个点到mst圈子的最小值
        for (int i = 1; i <= n; i++) {
            int t = -1;
            // 3. 枚举每个还没有确定最短路的点, 找不在st集合，并且到mst距离最小的点, 结果存到t
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            // 加入到集合中
            st[t] = true;
            // 除了第一个点+有点不连通,说明没有mst
            if (i > 1 && dist[t] == 0x3f3f3f3f) {
                return 0x3f3f3f3f;
            }
            if (i > 1) {
                res += dist[t];
            }

            // 找到了距离最小的点t，并用最小的点t去更新其他的点到mst的距离
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }

        }
        return res;
    }
}
