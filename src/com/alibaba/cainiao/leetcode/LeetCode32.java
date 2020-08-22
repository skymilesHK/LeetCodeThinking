package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. Longest Valid Parentheses
 * Hard
 *
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LeetCode32 {

    // https://www.youtube.com/watch?v=vre71lAMjqI
    // 23:03开始
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 右括号可以计算长度了
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    // 抵消
                    stack.poll();
                    int len = stack.isEmpty() ? i - (-1) : i - stack.peek();
                    res = Math.max(res, len);
                } else {
                    // 栈为空，右括号，说明是无法匹配的右括号,记录索引
                    stack.push(i);
                }
            }
        }
        return res;
    }

}
