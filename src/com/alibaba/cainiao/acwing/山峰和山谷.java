package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 山峰和山谷 {
    //https://www.acwing.com/problem/content/1108/

    static int N = 1009;
    static int n, peak = 0, valley = 0;
    static boolean hasHigher;   //如果旁边的是比我矮的，那我被标记说明是山峰
    static boolean hasLower;    //如果旁边的是比我高的，那我被标记说明是山谷
    static int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] g = new int[N][N];
    static boolean[][] st = new boolean[N][N];
    static Queue<Pair> q = new ArrayDeque<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!st[i][j]) {
                    hasHigher = false;
                    hasLower = false;
                    bfs(i, j);
                    if (!hasHigher) {
                        peak++;
                    }
                    if (!hasLower) {
                        valley++;
                    }
                }
            }
        }

        System.out.printf("%d %d\n", peak, valley);
    }

    private static void bfs(int x, int y) {
        q.offer(new Pair(x, y));
        st[x][y] = true;
        while (!q.isEmpty()) {
            Pair t = q.poll();
            for (int i = 0; i < 8; i++) {
                int a = t.x + dx[i], b = t.y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < n) {
                    if (g[a][b] != g[t.x][t.y]) {
                        if (g[a][b] > g[t.x][t.y]) {
                            // 如果周围是比我高的，那我就是山谷，将山峰标记
                            hasHigher = true;
                        } else {
                            // 剩下就是比我矮的1，那我就是山峰，将山谷标记
                            hasLower = true;
                        }
                    } else if (!st[a][b]) {
                        // 剩下的情况就是等于，就是可以练成一片的山峰或者山谷，进行bfs
                        st[a][b] = true;
                        q.offer(new Pair(a, b));
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
