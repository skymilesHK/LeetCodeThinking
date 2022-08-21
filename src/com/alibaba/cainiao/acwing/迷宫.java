package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 迷宫 {

    static int N = 101, n, k;
    static int xa, ya, xb, yb;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static Scanner in = new Scanner(System.in);

    // https://www.acwing.com/problem/content/1114/
    public static void main(String[] args) {
        k = in.nextInt();

        do {
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                String str = in.next();
                for (int j = 0; j < n; j++) {
                    g[i][j] = str.charAt(j);
                    st[i][j] = false;
                }
            }

            xa = in.nextInt();
            ya = in.nextInt();
            xb = in.nextInt();
            yb = in.nextInt();

            if (dfs(xa, ya)) {
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
        if (x == xb && y == yb) {
            return true;
        }

        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < n && !st[a][b]) {
                if (dfs(a, b)) {
                    return true;
                }
            }
        }
        return false;
    }
}
