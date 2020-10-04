package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 * Medium
 *
 *
 * Add to List
 *
 * Share
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class LeetCode739 {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(n);
        // 单调递减栈
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = 0;
            } else {
                right[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return right;
    }

}
