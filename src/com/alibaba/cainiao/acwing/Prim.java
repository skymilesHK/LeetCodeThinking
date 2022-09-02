package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {

    static int N = 502, M = 100002, n = 0, m = 0, INF = 0x3f3f3f3f, res = 0;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] set = new boolean[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    g[i][j] = INF;
                }
            }
        }

        // 读入m条边
        do {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            // 一定要取min，因为可能有重复边，但是权重不一样
            g[a][b] = Math.min(g[a][b], w);
            g[b][a] = Math.min(g[b][a], w);
        } while (--m > 0);

        prim();
        if (res >= INF / 2) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }

    private static void prim() {
        // 1. 初始化距离
        Arrays.fill(dist, INF);

        // 2. n次迭代，dijkstra是n-1次迭代
        for (int i = 1; i <= n; i++) {
            // 3. 枚举每个还没有确定生成树的点, 找不在st集合，并且距离起点最小的点, 结果存到t
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!set[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            set[t] = true;

            // 4. 除了第一个点 & 有点不连通,说明没有mst
            if (i > 0 && dist[t] == 0x3f3f3f3f) {
                res = INF;
                return;
            }

            if (i > 0) {
                res += dist[t];
            }

            // 5. 找到了距离最小的点t，并用最小的点t去更新其他的点到集合的距离
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }
        }
    }
}
