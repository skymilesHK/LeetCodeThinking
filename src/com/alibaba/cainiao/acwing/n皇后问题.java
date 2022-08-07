package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class n皇后问题 {

    static int N = 9, n = 0;
    static Scanner in = new Scanner(System.in);
    static boolean[] row = new boolean[N];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N + N];
    static boolean[] udg = new boolean[N + N];
    static char[][] g = new char[N][N];

    // https://www.acwing.com/solution/content/106979/
    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        dfs(0);
    }

    // u是搜索的行
    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // u是行, y是列
        for (int y = 0; y < n; y++) {
            // 这一列/正副对角线之前没有set过
            if (!col[y] && !dg[y + u] && !udg[y - u + n]) {
                g[u][y] = 'Q';
                col[y] = dg[u + y] = udg[y - u + n] = true;
                // 找下一层的
                dfs(u + 1);
                g[u][y] = '.';
                col[y] = dg[u + y] = udg[y - u + n] = false;
            }
        }
    }
}
