package com.alibaba.cainiao.leetcode;

/**
 * 766. 托普利茨矩阵
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 */
public class LeetCode766 {
    int m = 0, n = 0;
    public boolean isToeplitzMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
