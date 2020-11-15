package com.alibaba.cainiao.leetcode;

/**
 * 7. Reverse Integer
 * Easy
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class LeetCode7 {

    public int reverse(int x) {
        long res = 0;
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        // 123
        while (x != 0) {
            int mod = x % 10;
            res = res * 10 + mod;
            x /= 10;
        }
        if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
            return 0;
        }
        return flag ? (int) -res : (int) res;
    }

}
