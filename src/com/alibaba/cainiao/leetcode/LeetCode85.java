package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;

/**
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class LeetCode85 {

    int m = 0, n = 0;
    int res = 0;

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return 0;
        }

        m = matrix.length;
        n = matrix[0].length;
        int[][] h = buildHistogram(matrix);
        // 每层找最大矩形面积
        for (int i = 0; i < m; i++) {
            res = Math.max(res, largestRectangleArea(h[i]));
        }
        return res;
    }

    private int[][] buildHistogram(char[][] matrix) {
        int[][] h = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    h[i][j] = matrix[i][j] - '0';
                }
            } else {
                for (int j = 0; j < n; j++) {
                    h[i][j] = matrix[i][j] == '0' ? 0 : matrix[i][j] - '0' + h[i - 1][j];
                }
            }
        }
        return h;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 递增栈
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new ArrayDeque<>();
        // 2,1,5,6,2,3
        for (int i = n - 1; i >= 0; i--) {
            // 递增栈
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }

        return res;
    }
}
