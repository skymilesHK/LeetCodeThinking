package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 * Medium
 *
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * If multiple answers are possible, return any of them.
 *
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 *
 *
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * Example 4:
 *
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 * Example 5:
 *
 * Input: numerator = 1, denominator = 5
 * Output: "0.2"
 *
 *
 * Constraints:
 *
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 */
public class LeetCode166 {

    // https://www.acwing.com/video/1524/
    // 可能会爆int
    public String fractionToDecimal(int numerator, int denominator) {
        long x = numerator, y = denominator;
        if (x % y == 0) {
            return x / y + "";
        }

        String res = "";
        if ((x < 0) ^ (y < 0)) {
            res = "-";
        }
        x = Math.abs(x);
        y = Math.abs(y);
        res += x / y + ".";
        x %= y;

        Map<Long, Integer> map = new HashMap<>();
        while (x != 0) {
            if (map.containsKey(x)) {
                // 找循环节
                Integer endSize = map.get(x);
                res = res.substring(0, endSize) + "(" + res.substring(endSize) + ")";
                break;
            } else {
                map.put(x, res.length());   //记录余数的位置(next位置)
                x *= 10;
                res += x / y;
                x %= y;
            }
        }

        return res;
    }

}
