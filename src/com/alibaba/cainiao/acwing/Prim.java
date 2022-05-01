package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {

    static int N = 509, M = 100009, n = 0, m = 0;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] set = new boolean[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], 0x3f3f3f3f);
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

        int res = prim();
        if (res >= 0x3f3f3f3f) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }

    private static int prim() {
        // 最小生成树的树边权重之和
        int res = 0;
        // 1. 初始化距离
        Arrays.fill(dist, 0x3f3f3f3f);

        // 2. n次接待，dijkstra是n-1次迭代
        for (int i = 0; i < n; i++) {
            // 3. 枚举每个还没有确定最短路的点, 找不在st集合，并且距离起点最小的点, 结果存到t
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!set[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            set[t] = true;

            // 4. 除了第一个点+有点不连通,说明没有mst
            if (i > 0 && dist[t] == 0x3f3f3f3f) {
                return 0x3f3f3f3f;
            }

            if (i > 0) {
                res += dist[t];
            }

            // 5. 找到了距离最小的点t，并用最小的点t去更新其他的点到集合的距离
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }

        }

        return res;
    }

}
