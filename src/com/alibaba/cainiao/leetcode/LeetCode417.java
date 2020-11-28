package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * Medium
 *
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 *
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *
 *
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class LeetCode417 {

    List<List<Integer>> res = new ArrayList<>();
    int m = 0, n = 0;
    // 能到太平洋的坐标集合,true表示能到
    boolean[][] pacific = null;
    // 能到大西洋的坐标集合,true表示能到
    boolean[][] atlantic = null;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        m = matrix.length;;
        n = matrix[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        // 第一列, 最后一列
        for (int i = 0; i < m; i++) {
            // 西部太平洋，东部大西洋向内陆dfs搜索能到的点
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            dfs(matrix, i, n - 1, Integer.MIN_VALUE, atlantic);
        }

        // 第一行, 最后一行
        for (int j = 0; j < n; j++) {
            // 北部太平洋，南部大西洋向内陆dfs搜索能到的点
            dfs(matrix, 0, j, Integer.MIN_VALUE, pacific);
            dfs(matrix, m - 1, j, Integer.MIN_VALUE, atlantic);
        }

        // 分别标记出 pacific 和 atlantic 能到达的点，那么最终能返回的点就是二者均为 true 的点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    /**
     * 从[row, col]向内陆dfs搜索能到的点
     * @param matrix    原始数组
     * @param row       当前横坐标
     * @param column    当前纵坐标
     * @param preH      之前点的高度
     * @param visited   当前到达的大洋的点的坐标
     */
    private void dfs(int[][] matrix, int row, int column, int preH, boolean[][] visited) {
        if (visited[row][column] || matrix[row][column] < preH) {
            return;
        }

        visited[row][column] = true;
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = column + dy[i];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                dfs(matrix, x, y, matrix[row][column], visited);
            }
        }
        // 不用回溯
    }
}
