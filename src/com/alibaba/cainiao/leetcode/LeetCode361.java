package com.alibaba.cainiao.leetcode;

/**
 * Bomb Enemy
 * https://leetcode-cn.com/problems/bomb-enemy/
 */
public class LeetCode361 {
    // https://pan.baidu.com/play/video#/video?path=%2FVideo%2F%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%2F07-%E4%B9%9D%E7%AB%A0%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%2F%E4%B9%9D%E7%AB%A0%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%922_%E5%9D%90%E6%A0%87%E5%9E%8B%26%E4%BD%8D%E6%93%8D%E4%BD%9C%E5%9E%8B.mkv&t=-1
    // 1:35分钟
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    continue;
                }
                up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i - 1 >= 0) {
                    up[i][j] = up[i - 1][j];
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    continue;
                }
                down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i + 1 < m) {
                    down[i][j] = down[i + 1][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                    continue;
                }
                left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j - 1 >= 0) {
                    left[i][j] = left[i][j - 1];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                    continue;
                }
                right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j + 1 < n) {
                    right[i][j] = right[i][j + 1];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int t = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    res = Math.max(res, t);
                }
            }
        }

        return res;
    }
}
