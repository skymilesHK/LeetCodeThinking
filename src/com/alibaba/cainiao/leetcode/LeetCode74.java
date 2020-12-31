package com.alibaba.cainiao.leetcode;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        // 一维对应的下标
        int start = 0, end = m * n - 1, mid = 0;
        // 二维对应的下标
        int row = 0, col = 0;
        while (start + 1 < end) {
            // 这个mid index是一维二分的下标，要转化为二维对应的下标
            // 行坐标是mid / 列size, 列坐标是 mid % 列size
            mid = start + (end - start) / 2;
            row = mid / n;
            col = mid % n;
            if (matrix[row][col] > target) {
                end = mid;
            } else if (matrix[row][col] < target) {
                start = mid;
            } else {
                return true;
            }
        }

        if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) {
            return true;
        } else {
            return false;
        }
    }

}
