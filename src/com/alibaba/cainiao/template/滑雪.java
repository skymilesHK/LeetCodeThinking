package com.alibaba.cainiao.template;

import java.util.Scanner;

// https://www.acwing.com/problem/content/903/
public class 滑雪 {
    static Scanner in = new Scanner(System.in);
    static int N = 310;
    static int h[][] = new int[N][N], dp[][] = new int[N][N];
    static int n, m;
    static int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};

    public static int dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && h[a][b] < h[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(a, b) + 1);
            }
        }
        return dp[x][y];
    }

    public static void main(String args[]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                h[i][j] = in.nextInt();
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }

}
