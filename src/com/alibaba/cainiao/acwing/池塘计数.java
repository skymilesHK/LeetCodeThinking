package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 池塘计数 {

    // https://www.acwing.com/problem/content/1099/
    static int N = 1009;
    static int n, m, res = 0;
    static Queue<Pair> q = new ArrayDeque<>();
    static char[][] g = new char[N][N];
    // bfs基本都需要判断重复数组
    static boolean[][] st = new boolean[N][N];
    static int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            char[] charArr = in.next().toCharArray();
            for (int j = 0; j < m; j++) {
                g[i][j] = charArr[j];
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'W' && !st[i][j]) {
                    bfs(i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static void bfs(int r, int c) {
        q.offer(new Pair(r, c));
        st[r][c] = true;
        while (!q.isEmpty()) {
            Pair t = q.poll();
            for (int i = 0; i < 8; i++) {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && g[a][b] == 'W' && !st[a][b]) {
                    q.offer(new Pair(a, b));
                    st[a][b] = true;
                }
            }
        }
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
