package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 264. Ugly Number II
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class LeetCode264 {

    // https://leetcode-cn.com/problems/ugly-number-ii/solution/san-zhi-zhen-fang-fa-de-li-jie-fang-shi-by-zzxn/
    // 实际上pi的含义是有资格同i相乘的最小丑数的位置。
    // 这里资格指的是：如果一个丑数nums[pi]通过乘以i可以得到下一个丑数，那么这个丑数nums[pi]就永远失去了同i相乘的资格（没有必要再乘了）

    List<Integer> res = new ArrayList<>();

    public int nthUglyNumber(int n) {
        res.add(1);
        int p2 = 0, p3 = 0, p5 = 0;
        while (res.size() < n) {
            int next2 = res.get(p2) * 2;
            int next3 = res.get(p3) * 3;
            int next5 = res.get(p5) * 5;
            int next = Math.min(next2, Math.min(next3, next5));
            if (next == next2) {
                p2++;
            }
            if (next == next3) {
                p3++;
            }
            if (next == next5) {
                p5++;
            }
            res.add(next);
        }
        return res.get(n - 1);
    }

}
