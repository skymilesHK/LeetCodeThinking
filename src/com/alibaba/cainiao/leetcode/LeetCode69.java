package com.alibaba.cainiao.leetcode;

/**
 * 69. Sqrt(x)
 * Easy
 *
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 0, end = x, mid = x;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (mid > x / mid) {
                end = mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                return mid;
            }
        }

        // end^2 <= x
        if (end <= x / end) {
            return end;
        } else {
            return start;
        }
    }

}
