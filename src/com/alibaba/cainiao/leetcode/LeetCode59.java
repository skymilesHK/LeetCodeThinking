package com.alibaba.cainiao.leetcode;

/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class LeetCode59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int total = n * n;
        for (int i = 1, x = 0, y = 0, dir = 0; i <= total; i++) {
            res[x][y] = i;
            int a = x + dx[dir];
            int b = y + dy[dir];
            if (a < 0 || a >= n || b < 0 || b >= n || res[a][b] > 0) {
                dir = (dir + 1) % 4;
                a = x + dx[dir];
                b = y + dy[dir];
            }

            x = a;
            y = b;
        }

        return res;
    }

}
