package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 图中点的层次 {

    // https://www.acwing.com/problem/content/849/
    static int N = 100009, M = 2 * N, n, m, res = N, idx = 0;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] next = new int[M];
    static int[] dist = new int[N];
    static Queue<Integer> q = new ArrayDeque<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        // 距离-1表示没有访问过
        Arrays.fill(dist, -1);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
        }

        q.offer(1);
        dist[1] = 0;
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i = h[t]; i != -1; i = next[i]) {
                // j是邻节点
                int j = e[i];
                if (dist[j] == -1) {
                    q.offer(j);
                    dist[j] = dist[t] + 1;
                }
            }
        }
        System.out.println(dist[n]);
    }

    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }

}
