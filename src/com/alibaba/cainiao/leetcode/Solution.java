package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    int res = 0;
    int m = 0;
    int n = 0;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return res;
        }

        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (grid[row][column] == '1') {
            grid[row][column] = '0';
        }

        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = column + dy[i];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                dfs(grid, x, y);
            }
        }
    }

}
