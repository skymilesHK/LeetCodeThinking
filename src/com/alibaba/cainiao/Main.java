package com.alibaba.cainiao;

import java.util.*;

public class Main {

    static int N = 509;
    static int n, m;
    static int[][] g = new int[N][N];       //稠密图一般使用邻接矩阵
    static int[] dist = new int[N];         //记录每个节点距离起点的距离
    static boolean[] st = new boolean[N];   //已经确定最短路的集合
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = 0x3f3f3f3f;
                }
            }
        }

        do {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            g[a][b] = Math.min(g[a][b], w);
        } while (--m > 0);

        System.out.println(dijkstra());
    }

    // 单源最短距离(无负权边)
    private static int dijkstra() {
        // 1. d距离数组初始化,d[1]=0,第一个节点是1开始，不是0开始
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;

        // 2. 做n次
        for (int i = 1; i <= n; i++) {
            int t = -1;
            // 不在s集合，更短的路径，则进行更新
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            // 加入到s集合中
            st[t] = true;
            //找到了距离最小的点t，并用最小的点t去更新其他的点到起点的距离
            for (int j = 1; j <= n; ++j) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }

        // 如果起点到达不了n号节点，则返回-1
        if (dist[n] >= 0x3f3f3f3f) {
            return -1;
        }
        // 返回起点距离n号节点的最短距离
        return dist[n];
    }
}
