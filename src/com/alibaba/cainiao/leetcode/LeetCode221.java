package com.alibaba.cainiao.leetcode;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 *
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
public class LeetCode221 {
    // https://www.bilibili.com/video/BV1mA411q7Sw?from=search&seid=15087881643337886113
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j]点(i, j)为右下角的正方形的最大边长
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0] == 1 ? 1: 0;
        int res = dp[0][0];

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }

        for (int j = 1; j < n; ++j) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    // 最小边长里面区最大的
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }
}
