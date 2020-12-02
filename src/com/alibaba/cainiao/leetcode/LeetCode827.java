package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 827. Making A Large Island
 * Hard
 *
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 *
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 *
 * Example 1:
 *
 * Input: [[1, 0], [0, 1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 *
 * Input: [[1, 1], [1, 0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 *
 * Input: [[1, 1], [1, 1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *
 *
 * Notes:
 *
 * 1 <= grid.length = grid[0].length <= 50.
 * 0 <= grid[i][j] <= 1.
 */
public class LeetCode827 {
    int res = 0;
    int color = 1;  // 这个color既表示每一个小岛都编上一个号，又通过这个颜色表示visited数组，染成某个颜色(>1)后就表示遍历过了
    int m = 0, n = 0;
    int[] area = null;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        area = new int[m * n];

        // 找1的点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ++color;
                    area[color] = getArea(grid, i, j);
                    res = Math.max(res, area[color]);
                }
            }
        }

        // 找0的点,可以填充
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int a = 1;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[i];
                        int y = j + dy[i];
                        int subColor = getColor(grid, x, y);
                        a += area[subColor];
                    }
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    private int getColor(int[][] grid, int row, int column) {
        return (row < 0 || row >= m || column < 0 || column >= m) ? 0 : grid[row][column];
    }

    // Return the area of a connected component, set all elements to color.
    private int getArea(int[][] grid, int row, int column) {
        if (row < 0 || row >= m || column < 0 || column >= n || grid[row][column] != 1) {
            return 0;
        }
        // grid[row][column]必为1
        int levelArea = grid[row][column];
        grid[row][column] = color;
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = column + dy[i];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                levelArea += getArea(grid, x, y);
            }
        }
        return levelArea;
    }
}
