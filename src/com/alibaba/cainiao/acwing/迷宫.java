package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 迷宫 {
    static int N = 101, n, k;
    static int ra, rb, ca, cb;
    static char[][] g;
    static boolean[][] st;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        k = in.nextInt();
        do {
            n = in.nextInt();
            st = new boolean[N][N];
            g = new char[N][N];
            for (int i = 0; i < n; i++) {
                char[] chars = in.next().toCharArray();
                g[i] = chars;
            }

            ra = in.nextInt();
            ca = in.nextInt();
            rb = in.nextInt();
            cb = in.nextInt();

            if (dfs(ra, ca)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } while (--k > 0);

    }

    private static boolean dfs(int x, int y) {
        if (g[x][y] == '#') {
            return false;
        }
        if (x == rb && y == cb) {
            return true;
        }

        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b > n || st[a][b] || g[a][b] == '#') {
                continue;
            }

            if (dfs(a, b)) {
                return true;
            }
        }

        return false;
    }
}
