package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class LeetCode54 {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    // https://www.acwing.com/video/1391/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        // 遍历m*n
        int tot = m * n, row = 0, col = 0;
        for (int i = 0, dir = 0; i < tot; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int x = row + dx[dir];
            int y = col + dy[dir];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                // 因为dir 一直在[0,1,2,3,0,1,2,3...]一直循环取值,用于修正x，y
                dir = (dir + 1) % 4;
                x = row + dx[dir];
                y = col + dy[dir];
            }
            row = x;
            col = y;
        }

        return res;
    }

}
