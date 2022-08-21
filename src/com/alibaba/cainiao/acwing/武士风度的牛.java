package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 武士风度的牛 {

    static int N = 151, M = 151, n, m;
    static Pair start, end;
    static char[][] g = new char[N][N];
    static int[][] dist = new int[N][N];
    static Queue<Pair> q = new ArrayDeque<>();
    static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        m = in.nextInt();
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            char[] chars = in.next().toCharArray();
            for (int j = 0; j < m; j++) {
                g[i][j] = chars[j];
                //初始化为-1;可以表示为来没来过这个点
                dist[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'K') {
                    start = new Pair(i, j);
                } else if (g[i][j] == 'H') {
                    end = new Pair(i, j);
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        q.offer(start);
        dist[start.x][start.y] = 0;
        while (!q.isEmpty()) {
            Pair t = q.poll();
            for (int i = 0; i < 8; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < n && g[a][b] != '*' && dist[a][b] == -1) {
                    dist[a][b] = dist[t.x][t.y] + 1;
                    if (a == end.x && b == end.y) {
                        return dist[a][b];
                    }
                    q.offer(new Pair(a, b));
                }
            }
        }
        return -1;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
