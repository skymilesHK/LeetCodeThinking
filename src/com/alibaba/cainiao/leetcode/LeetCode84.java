package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stk = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stk.peek();
            }
            stk.push(i);
        }

        stk.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stk.peek();
            }
            stk.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }

}
