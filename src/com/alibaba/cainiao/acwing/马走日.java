package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 马走日 {

    static int N = 10;
    static int n, m, x, y, res, T;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] st;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        T = in.nextInt();
        do {
            n = in.nextInt();
            m = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            st = new boolean[N][N];
            res = 0;
            dfs(x, y, 1);
            System.out.println(res);
        } while (--T > 0);
    }

    private static void dfs(int x, int y, int cnt) {
        // st[x][y] = true;
        // 先判断cnt == n * m, 就是为了可以让st[x][y]恢复成false
        if (cnt == n * m) {
            res++;
            return;
        }
        st[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            // 题目要求不重不漏
            if (a < 0 || a >= n || b < 0 || b >= m || st[a][b]) {
                continue;
            }

            dfs(a, b, cnt + 1);
        }
        st[x][y] = false;
    }

}
