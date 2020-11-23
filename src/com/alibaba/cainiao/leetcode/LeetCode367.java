package com.alibaba.cainiao.leetcode;

/**
 * 367. Valid Perfect Square
 * Easy
 *
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num <= 2^31 - 1
 */
public class LeetCode367 {

    public boolean isPerfectSquare(int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        long start = 1, end = n, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (mid * mid > n) {
                end = mid;
            } else if (mid * mid < n) {
                start = mid;
            } else {
                return true;
            }
        }

        if (start * start == n || end * end == n) {
            return true;
        }
        return false;
    }

}
