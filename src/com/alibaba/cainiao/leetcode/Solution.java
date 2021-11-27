package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    static int N = 100009;
    static int n, m = 0;

    static int idx = 0;
    static int[] h = new int[N];            // 头节点下标列表
    static int[] next = new int[N];         // 下一个节点的下标
    static int[] e = new int[N];            // i下标的节点本身
    static int[] w = new int[N];            // i下标的节点权重
    static int[] dist = new int[N];         // 到下标1的节点的距离
    static int[] cnt = new int[N];          //
    static boolean[] st = new boolean[N];   // 需要st[i]数组，保证队列里面只有一个i
    static Queue<Integer> q = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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

        int res = spfa();
        if (res == -1) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }

    private static int spfa() {
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        q.offer(1);
        st[1] = true;
        while (!q.isEmpty()) {
            Integer t = q.poll();
            st[t] = false;

            for (int i = h[t]; i != -1; i = next[i]) {
                int b = e[i];
                if (dist[t] + w[i] < dist[b]) {
                    dist[b] = dist[t] + w[i];
                    if (!st[b]) {
                        st[b] = true;
                        q.offer(b);
                    }
                }
            }
        }

        if (dist[n] >= 0x3f3f3f3f) {
            return -1;
        } else {
            return dist[n];
        }
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        next[idx] = h[a];
        w[idx] = c;
        h[a] = idx++;
    }
}
