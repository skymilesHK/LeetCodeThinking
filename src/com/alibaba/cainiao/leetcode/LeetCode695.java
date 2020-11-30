package com.alibaba.cainiao.leetcode;

public class LeetCode695 {

    private int m = 0, n = 0, res = 0;
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int row, int column) {
        int levelArea = grid[row][column];
        grid[row][column] = 0;
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = column + dy[i];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                levelArea += dfs(grid, x, y);
            }
        }
        return levelArea;
    }

}
