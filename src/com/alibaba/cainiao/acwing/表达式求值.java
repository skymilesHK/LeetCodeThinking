package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class 表达式求值 {
    // https://www.acwing.com/problem/content/3305/
    static HashMap<Character, Integer> priority = new HashMap<>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};
    static Deque<Integer> num = new ArrayDeque<>();
    static Deque<Character> op = new ArrayDeque<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String str = in.next();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                int x = 0, j = i;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    x = x * 10 + str.charAt(j++) - '0';
                }
                i = j - 1;
                num.push(x);
            } else if (ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    eval();
                }
                op.pop();
            } else {
                // +, -, *, /, 开头就是+,-符号
                while (!op.isEmpty() && op.peek() != '(' && priority.get(op.peek()) >= priority.get(ch)) {
                    eval();
                }
                op.push(ch);
            }
        }

        // 没有做完的op继续做
        while (!op.isEmpty()) {
            eval();
        }
        System.out.println(num.pop());
    }

    private static void eval() {
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
        } else if (o == '/') {
            res = a / b;
        }
        num.push(res);
    }
}
