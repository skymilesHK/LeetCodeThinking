package com.alibaba.cainiao.leetcode;

/**
 * 1254. Number of Closed Islands
 * Medium
 *
 * 741
 *
 * 22
 *
 * Add to List
 *
 * Share
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * Example 2:
 *
 *
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
public class LeetCode1254 {
    int m = 0, n = 0, res = 0;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    boolean reachedBoundary = false;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    reachedBoundary = false;
                    dfs(grid, i, j);
                    if (!reachedBoundary) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row >= m || row < 0 || col >= n || col < 0) {
            reachedBoundary = true;
            return;
        }
        if (grid[row][col] != 0) {
            return;
        }
        grid[row][col] = -1;
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            dfs(grid, x, y);
        }
    }

}
