package com.alibaba.cainiao.leetcode;

public class LeetCode641 {

    // 队头存值下标，第一个存值的位置
    int h = 0;
    // 队尾存值下标的后一位，含义是下一个空的位置，正常取值范围[h, t - 1]
    int t = 0;
    int[] q = null;

    private int get(int idx) {
        return (idx + q.length)% q.length;
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode641(int k) {
        q = new int[k + 1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        h = get(h - 1);
        q[h] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        q[t++] = value;
        if (t == q.length) {
            t = 0;
        }

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (++h == q.length) {
            h = 0;
        }

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        t = get(t - 1);
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return  -1;
        }
        return q[get(h)];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return  -1;
        }
        return q[get(t - 1)];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return h == t;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return get(t + 1) == h;
    }
}
