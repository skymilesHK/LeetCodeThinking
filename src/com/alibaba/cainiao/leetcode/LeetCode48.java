package com.alibaba.cainiao.leetcode;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 按照对角线翻
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        // 对折交换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }
    }

}
