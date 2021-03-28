package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode225 {

    Queue<Integer> q;   // 数据队列
    Queue<Integer> c;   // 辅助队列

    /** Initialize your data structure here. */
    public LeetCode225() {
        q = new ArrayDeque<>();
        c = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int n = q.size();
        for (int i = 1; i <= n - 1; i++) {
            c.offer(q.poll());
        }
        Integer val = q.poll();
        while (!c.isEmpty()) {
            q.offer(c.poll());
        }
        return val;
    }

    /** Get the top element. */
    public int top() {
        int n = q.size();
        for (int i = 1; i <= n - 1; i++) {
            c.offer(q.poll());
        }
        Integer val = q.poll();
        while (!c.isEmpty()) {
            q.offer(c.poll());
        }
        q.offer(val);
        return val;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }

}
