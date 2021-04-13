package com.alibaba.cainiao.leetcode;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class LeetCode63 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int tot = m * n;
        int start = 0, end = tot - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            // 一维转二维
            int midX = mid / 4;
            int midY = mid % 4;
            if (matrix[midX][midY] == target) {
                return true;
            } else if (matrix[midX][midY] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return false;
    }
}
