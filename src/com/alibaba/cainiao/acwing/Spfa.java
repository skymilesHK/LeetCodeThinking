package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Spfa {

    static int N = 100009;
    static int n, m = 0, idx = 0;

    static int[] h = new int[N];            // 头节点下标列表
    static int[] next = new int[N];         // 下一个节点的下标
    static int[] e = new int[N];            // i下标的节点本身
    static int[] w = new int[N];            // i下标的节点权重
    static int[] dist = new int[N];         // 到下标1的节点的距离
    static boolean[] st = new boolean[N];   // st[i]数组表示i节点在不在队列中，保证队列里面只有一个i
    static Queue<Integer> q = null;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        n = in.nextInt();
        m = in.nextInt();
        q = new ArrayDeque<>(n);
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a, b, c);
        }

        spfa();

        if (dist[n] >= 0x3f3f3f3f / 2) {
            System.out.println("impossible");
        } else {
            System.out.println(dist[n]);
        }
    }

    private static void spfa() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        q.offer(1);
        st[1] = true;

        while (!q.isEmpty()) {
            Integer t = q.poll();
            // t点出了队列，更新st
            st[t] = false;

            // 更新t点所有邻边
            for (int i = h[t]; i != -1; i = next[i]) {
                // b 邻点, t -> b
                int b = e[i];
                int c = w[i];
                if (dist[b] > dist[t] + c) {
                    dist[b] = dist[t] + c;
                    if (!st[b]) {
                        // 有正向反馈，就加入队列
                        q.offer(b);
                        st[b] = false;
                    }
                }
            }
        }

    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
