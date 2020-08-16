package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 743. 网络延迟时间
 * 有 N 个网络节点，标记为 1 到 N。
 *
 * 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * 输出：2
 *
 *
 * 注意:
 *
 * N 的范围在 [1, 100] 之间。
 * K 的范围在 [1, N] 之间。
 * times 的长度在 [1, 6000] 之间。
 * 所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100
 */
public class LeetCode743 {

    int g[][], dist[];      // g[][]存储图的邻接矩阵, dist[]表示每个点到起点的距离
    boolean st[];           // 存储每个点的最短距离是否已确定
    int INF = 0x3f3f3f3f;   //设置无穷大

    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0 || times[0].length == 0) {
            return -1;
        }

        // 人类下标
        g = new int[N + 1][N + 1];
        st = new boolean[N + 1];
        dist = new int[N + 1];

        g[0][0] = INF;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=N; j++) {
                if (i == j) {
                    g[i][j] = 0;
                } else {
                    g[i][j] = INF;
                }
            }
        }

        // 遍历times填充邻接表
        for (int[] time : times) {
            g[time[0]][time[1]] = time[2];
        }

        return dijkstra(N, K);
    }

    int dijkstra(int N, int K) {
        Arrays.fill(dist, INF);
        // 第K个点到自身的距离为0
        dist[K] = 0;

        // 有N个点所以要进行N次 迭代
        for (int i = 0; i < N; i++) {
            // 当前没有访问的点
            int t = -1;

            // 不在s集合，并且距离起点最小的点
            // 如果没有更新过，则进行更新
            // 发现更短的路径, 则进行更新
            for (int j = 1; j <= N; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            //加入到s集合中
            st[t] = true;
            //找到了距离最小的点t，并用最小的点t去更新其他的点到起点的距离
            for (int j = 1; j <= N; ++j) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }

        int res = -1;
        // 如果起点到达不了n号节点，则返回-1
        for (int i = 1; i <= dist.length; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == INF ? -1 : res;
    }
}
