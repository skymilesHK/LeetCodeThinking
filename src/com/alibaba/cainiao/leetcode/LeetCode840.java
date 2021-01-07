package com.alibaba.cainiao.leetcode;

/**
 * 840. Magic Squares In Grid
 *
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的矩阵 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 * 样例
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 *
 * 而这一个不是：
 * 384
 * 519
 * 762
 *
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 注意
 * 1 <= grid.length = grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 *
 */
public class LeetCode840 {

    int m = 0, n = 0;

    public int numMagicSquaresInside(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (check(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(int[][] grid, int x, int y) {
        boolean[] visited = new boolean[10];
        for (int i = x; i < x + 3; i++) {
            int sum = 0;
            for (int j = y; j < y + 3; j++) {
                if (grid[i][j] >= 10 || visited[grid[i][j]]) {
                    return false;
                }

                sum += grid[i][j];
                visited[grid[i][j]] = true;
            }
            if (sum != 15) {
                return false;
            }
        }

        for (int j = y; j < y + 3; j++) {
            int sum = 0;
            for (int i = x; i < x + 3; i++) {
                sum += grid[i][j];
            }
            if (sum != 15) {
                return false;
            }
        }

        if (grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] != 15) {
            return false;
        }
        if (grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y] != 15) {
            return false;
        }

        return true;
    }

}
