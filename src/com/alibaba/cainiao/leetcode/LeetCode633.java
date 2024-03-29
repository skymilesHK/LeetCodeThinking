package com.alibaba.cainiao.leetcode;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 */
public class LeetCode633 {
    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        // a*a + b*b = c
        for (long a = 0; a * a <= c; a++) {
            // y是否是一个完全平方数
            long y = c - a * a;
            double b = Math.sqrt(y);
            if ((long) b * b == y) {
                return true;
            }
        }
        return false;
    }
}
