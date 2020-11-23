package com.alibaba.cainiao.leetcode;

import java.util.LinkedList;

/**
 * 372. Super Pow
 * Medium
 *
 *
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 2, b = [3]
 * Output: 8
 * Example 2:
 *
 * Input: a = 2, b = [1,0]
 * Output: 1024
 * Example 3:
 *
 * Input: a = 1, b = [4,3,3,8,5,2]
 * Output: 1
 * Example 4:
 *
 * Input: a = 2147483647, b = [2,0,0]
 * Output: 1198
 *
 *
 * Constraints:
 *
 * 1 <= a <= 231 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b doesn't contain leading zeros.
 */
public class LeetCode372 {

    int p = 1337;
    public int superPow(int a, int[] b) {
        LinkedList<Integer> l = new LinkedList<>();
        for (int val : b) {
            l.addLast(val);
        }
        return sp(a, l);
    }

    private int sp(int a, LinkedList<Integer> l) {
        if (l.isEmpty()) {
            return 1;
        }
        int last = l.removeLast();
        return qmi(sp(a, l), 10) * qmi(a, last) % p;
    }

    // 必须要默写
    private int qmi(int a, int k) {
        int res = 1;
        while (k != 0) {
            // k的末尾是1
            if ((k & 1) == 1) {
                res = res * a % p;
            }
            // a不断平方
            a = a * a % p;
            k >>= 1;
        }
        return res;
    }
}
