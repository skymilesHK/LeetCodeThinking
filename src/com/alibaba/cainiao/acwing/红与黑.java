package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 红与黑 {

    // https://www.acwing.com/problem/content/1115/
    static int n, m, res, N = 21;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            //多组测试数据
            res = 0;
            m = in.nextInt();
            n = in.nextInt();
            if (m == 0 && n == 0) {
                break;
            }

            int x = 0;
            int y = 0;

            for (int i = 0; i < n; i++) {
                String str = in.next();
                for (int j = 0; j < m; j++) {
                    g[i][j] = str.charAt(j);
                    st[i][j] = false;
                    if (g[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }

            dfs(x, y);
            System.out.println(res);
        }
    }

    private static void dfs(int x, int y) {
        st[x][y] = true;
        res++;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && !st[a][b] && g[a][b] == '.') {
                dfs(a, b);
            }
        }
    }
}
