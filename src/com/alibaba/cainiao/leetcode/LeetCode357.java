package com.alibaba.cainiao.leetcode;

/**
 * 357. Count Numbers with Unique Digits
 * Medium
 *
 * 480
 *
 * 937
 *
 * Add to List
 *
 * Share
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 *
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 *
 *
 * Constraints:
 *
 * 0 <= n <= 8
 */
public class LeetCode357 {
    // 总结归纳
    // n = 0, count = 1
    // n = 1, count = 10
    // n = 2, count = 10 + 9*9
    // n = 3, count = 10 + 9*9 + 9*9*8
    // ...
    // n > 10时，numbers不会再增加了
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }

        n = Math.min(10, n);
        // dp[i] 表示i位数,各位数字都不同的的个数
        int[] dp = new int[n + 1];
        //注意这里dp[1]要写成9不能是10
        dp[1] = 9;
        // dp[2] = 9 * 9; dp[3] = 9 * 9 * 8
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (11 - i);
        }

        // 0位特别判断是1
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res += dp[i];
        }
        return res;
    }

}
