package com.alibaba.cainiao.leetcode;

public class LeetCode622 {
    // 队头下标
    int h = 0;
    // 队尾下标的后一位，正常取值范围[h, t - 1]
    int t = 0;
    int[] q = null;

    public LeetCode622(int k) {
        q = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        q[t++] = value;
        if (t == q.length) {
            t = 0;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (++h == q.length) {
            h = 0;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return q[h];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int idx = t - 1;
        if (idx < 0) {
            idx += q.length;
        }
        return q[idx];
    }

    public boolean isEmpty() {
        return h == t;
    }

    public boolean isFull() {
        return (t + 1) % q.length == h;
    }
}
