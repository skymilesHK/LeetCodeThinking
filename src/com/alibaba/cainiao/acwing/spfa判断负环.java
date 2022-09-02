package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class spfa判断负环 {

    static int N = 2001, M = 10001;
    static int n, m, idx;
    static int[] h = new int[N];                    // 头节点下标列表
    static int[] next = new int[M];                 // 下一个节点的下标
    static int[] e = new int[M];                    // i下标的节点本身
    static int[] w = new int[M];                    // i下标的节点权重
    static int[] dist = new int[N];                 // 到下标1的节点的距离
    static boolean[] st = new boolean[N];           // st[i]数组表示i节点在不在队列中，保证队列里面只有一个i
    static int[] cnt = new int[N];                  // 当前到原点的边的数量
    static Queue<Integer> q = new ArrayDeque<>(N);  // 队列
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a, b, c);
        }

        if (spfa()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean spfa() {
        // 并不是判断从原点1开始的负环, 所以所有点加入队列来判断
        for (int i = 1; i <= n; i++) {
            st[i] = true;
            q.offer(i);
        }

        while (!q.isEmpty()) {
            // a -> b
            int a = q.poll();
            st[a] = false;

            for (int i = h[a]; i != -1; i = next[i]) {
                int b = e[i];
                int c = w[i];
                if (dist[a] + c < dist[b]) {
                    dist[b] = dist[a] + c;
                    cnt[b] = cnt[a] + 1;
                    if (cnt[b] >= n) {
                        return true;
                    }

                    if (!st[b]) {
                        st[b] = true;
                        q.offer(b);
                    }
                }
            }
        }

        return false;
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        next[idx] = h[a];
        h[a] = idx++;
    }

}
