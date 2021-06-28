package com.alibaba.cainiao.leetcode;

/**
 * 576. 出界的路径数
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 *
 * https://leetcode-cn.com/problems/out-of-boundary-paths/
 */
public class LeetCode576 {

    // https://www.acwing.com/video/2037/
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int MOD = (int) (1E9 + 7);
    public int findPaths(int m, int n, int N, int x, int y) {
        if (N == 0) {
            return 0;
        }
        // 从边界外移动了N步后到[x,y]这个点的方案数
        int[][][] dp = new int[m][n][N + 1];
        // 那么对于四个角落，因为只能从两个边过来，所以N=1时四个角点的dp值是2。而对于不是角落的边，由于只能从一个边过来，所以N=1时候边的dp值是1。
        for (int j = 0; j < n; j++) {
            dp[0][j][1]++;
            dp[m - 1][j][1]++;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0][1]++;
            dp[i][n - 1][1]++;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int u = 0; u < 4; u++) {
                        int a = i + dx[u];
                        int b = j + dy[u];
                        if (a >= 0 && a < m && b >= 0 && b < n) {
                            dp[i][j][k] = (dp[i][j][k] + dp[a][b][k - 1]) % MOD;
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int k = 1; k <= N; k++) {
            res += dp[x][y][k];
        }

        return res;
    }

}
