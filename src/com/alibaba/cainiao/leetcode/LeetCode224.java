package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class LeetCode224 {

    public int calculate(String s) {
        Deque<Integer> num = new ArrayDeque<>(s.length());
        Deque<Character> op = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                // 数字
                int x = 0, j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + (s.charAt(j) - '0');
                    j++;
                }
                // 注意是i-1,因为for循环有i++
                i = j - 1;
                num.push(x);
            } else if (ch == '(') {
                // '('
                op.push(ch);
            } else if (ch == ')') {
                // ')'
                if (!op.isEmpty()) {
                    while (op.peek() != '(') {
                        eval(num, op);
                    }

                    // 弹出'('
                    op.pop();
                }
            } else {
                // '+','-'
                while (!op.isEmpty() && op.peek() != '(') {
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
        }

        num.push(res);
    }
}
