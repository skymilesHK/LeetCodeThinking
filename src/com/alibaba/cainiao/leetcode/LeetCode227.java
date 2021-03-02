package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 227. 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class LeetCode227 {
    // https://www.acwing.com/video/1610/
    Map<Character, Integer> priority = new HashMap<>();
    public int calculate(String s) {
        Deque<Integer> num = new ArrayDeque<>(s.length());
        Deque<Character> op = new ArrayDeque<>(s.length());
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        s = "0" + s;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch)) {
                int x = 0, j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + (s.charAt(j++) - '0');
                }
                num.push(x);
            } else {
                // 运算符号
                while (!op.isEmpty() && priority.get(op.peek()) >= priority.get(ch)) {
                    eval(num, op);
                }
                op.push(ch);
            }
        }
        // 没有做完的op继续做
        while (!op.isEmpty()) {
            eval(num, op);
        }

        return num.pop();
    }

    private void eval(Deque<Integer> num, Deque<Character> op) {
        Integer b = num.pop();
        Integer a = num.pop();
        Character o = op.pop();
        int res = 0;
        if (o == '+') {
            res = a + b;
        } else if (o == '-') {
            res = a - b;
        } else if (o == '*') {
            res = a * b;
        } else {
            res = a / b;
        }
        num.push(res);
    }
}
