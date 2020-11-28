package com.alibaba.cainiao.leetcode;

/**
 * 329. Longest Increasing Path in a Matrix
 * Hard
 *
 *
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 *
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 * Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LeetCode329 {
    int m = 0;
    int n = 0;
    int res = 1;
    int[][] memo = null;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int subLen = dfs(matrix, i, j);
                res = Math.max(res, subLen);
            }
        }
        return res;
    }

    // 以（i,j）作为起点寻找最长子路径值是固定的所以可以记忆化
    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] > 0) {
            return memo[row][col];
        }
        int subLen = 1;
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[row][col]) {
                // 1 + dfs(matrix, x, y)会走4次，上下左右，所以要取得一个方向最大的值
                subLen = Math.max(subLen, 1 + dfs(matrix, x, y));
            }
        }
        memo[row][col] = subLen;
        return subLen;
    }

}
