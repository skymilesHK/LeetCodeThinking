package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode856 {

    public int scoreOfParentheses(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>(n);
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(0);
            } else {
                Integer t = stack.pop();
                if (t == 0) {
                    t = 1;
                } else {
                    t *= 2;
                }

                stack.push(stack.pop() + t);
            }
        }

        return stack.pop();
    }

}
