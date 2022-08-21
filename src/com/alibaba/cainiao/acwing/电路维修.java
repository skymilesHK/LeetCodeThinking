package com.alibaba.cainiao.acwing;

import java.util.*;

public class 电路维修 {

    // https://www.acwing.com/solution/content/21775/
    // https://www.acwing.com/solution/content/82459/

    static char[] cs = new char[]{'\\', '/', '\\', '/'};//'/'需要转义
    static int[] dx = new int[]{-1, -1, 1, 1};
    static int[] dy = new int[]{-1, 1, 1, -1};
    static int[] ix = new int[]{-1, -1, 0, 0};
    static int[] iy = new int[]{-1, 0, 0, -1};
    static int N = 502, INF = 0x3f3f3f3f;
    static int n, m;
    static char[][] g;
    static boolean[][] st = new boolean[N][N];
    static int[][] dist = new int[N][N];
    static Deque<Pair> q = new ArrayDeque<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        while (T-- > 0) {
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 0; i < n; i++) {
                String s = in.next();
                for (int j = 0; j < m; j++) {
                    g[i][j] = s.charAt(j);
                }
            }

            //n + m不是偶数表示无解
            if (((n + m) & 1) != 0) {
                System.out.println("NO SOLUTION");
            } else {
                System.out.println(bfs());
            }
        }
    }

    static int bfs() {
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(st[i], false);
        }
        q = new ArrayDeque<>();
        q.offer(new Pair(0, 0));
        dist[0][0] = 0;
        while (!q.isEmpty()) {
            Pair t = q.pollFirst();
            int x = t.x, y = t.y;
            if (x == n && y == m) {
                return dist[x][y];
            }
            if (st[x][y]) {
                continue;
            }
            st[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                // a, b是点不是格子，最大范围是[n, m]
                if (a < 0 || a > n || b < 0 || b > m) {
                    continue;
                }
                int ga = x + ix[i], gb = y + iy[i];
                int w = g[ga][gb] == cs[i] ? 0 : 1; //观察是否需要转动，若处于理想状态则权值是0，否则需要旋转1次权值是1
                int d = dist[x][y] + w;
                if (d < dist[a][b]) {
                    dist[a][b] = d;
                    if (w == 1) {
                        q.offerLast(new Pair(a, b));
                    } else {
                        q.offerFirst(new Pair(a, b));
                    }
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
