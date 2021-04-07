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

    // https://www.acwing.com/video/1355/
    // https://www.acwing.com/solution/content/114/
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        //用 start 记录一个新的可能合法的子串的起始位置。初始设为 0。
        for (int i = 0, start = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 右括号可以计算长度了
                if (!stack.isEmpty()) {
                    Integer t = stack.pop();
                    if (!stack.isEmpty()) {
                        res = Math.max(res, i - stack.peek());
                    } else {
                        // ()
                        res = Math.max(res, i - start + 1);
                    }
                } else {
                    // 栈为空，右括号，说明是无法匹配的右括号,记录下一个合法子串的起始位置
                    start = i + 1;
                }
            }
        }
        return res;
    }

}
