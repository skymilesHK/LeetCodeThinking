package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    int[][] g = new int[101][101];  // g[][]存储图的邻接矩阵, dist[]表示每个点到起点的距离
    int[] d = new int[101];
    boolean st[] = new boolean[101];// 存储每个点的最短距离是否已确定

    // 问至少需要多少时间才能从K到达任何一个结点。这实际上是一个有向图求最短路径的问题，求出K点到每一个点到最短路径，然后取其中最大的一个就是需要的时间了。
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0 || times[0].length == 0) {
            return -1;
        }

        // 初始化g图
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <=N; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = 0x3f3f3f3f;
                }
            }
        }

        // 遍历times填充邻接表
        for (int[] time : times) {
            g[time[0]][time[1]] = time[2];
        }

        return dijkstra(N, K);
    }

    private int dijkstra(int N, int K) {
        // 填充d距离数组
        Arrays.fill(d, 0x3f3f3f3f);
        // 第K个点到自身的距离为0
        d[K] = 0;

        // 有N个点所以要进行N次 迭代
        for (int i = 1; i <= N; i++) {
            // 当前没有访问的点
            int t = -1;

            // 不在s集合，并且距离起点最小的点,如果没有更新过，则进行更新,发现更短的路径, 则进行更新
            for (int j = 1; j <= N; j++) {
                if (!st[j] && (t == -1 || d[j] < d[t])) {
                    t = j;
                }
            }

            //加入到s集合中
            st[t] = true;
            //找到了距离最小的点t，并用最小的点t去更新其他的点到起点的距离
            for (int j = 1; j <= N; j++) {
                d[j] = Math.min(d[j], d[t] + g[t][j]);
            }
        }

        int res = -1;
        // 如果起点到达不了n号节点，则返回-1
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, d[i]);
        }
        return res >= 0x3f3f3f3f / 2 ? -1 : res;
    }
}
