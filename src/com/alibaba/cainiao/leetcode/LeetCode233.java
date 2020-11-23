package com.alibaba.cainiao.leetcode;

import java.util.LinkedList;

/**
 * 233. Number of Digit One
 * Hard
 *
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * Example:
 *
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class LeetCode233 {
    // https://leetcode-cn.com/problems/number-of-digit-one/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-50/
    // 直接看题解的例子
    // https://www.acwing.com/video/1616/   代码
    public int countDigitOne(int n) {
        LinkedList<Integer> nums = new LinkedList<>();
        while (n > 0) {
            nums.addFirst(n % 10);
            n /= 10;
        }

        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int d = nums.get(i);
            int left = 0, right = 0, p = 1;
            for (int j = 0; j < i; j++) {
                left = left * 10 + nums.get(j);
            }
            for (int j = i + 1; j < nums.size(); j++) {
                right = right * 10 + nums.get(j);
                p = p * 10;
            }

            if (d == 0) {
                res += left * p;
            } else if (d == 1) {
                res += left * p + right + 1;
            } else {
                res += (left + 1) * p;
            }
        }

        return res;
    }

}
