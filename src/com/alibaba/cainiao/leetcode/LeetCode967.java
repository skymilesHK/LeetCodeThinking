package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 967. Numbers With Same Consecutive Differences
 * Medium
 *
 * 617
 *
 * 120
 *
 * Add to List
 *
 * Share
 * Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
 *
 * Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * Example 2:
 *
 * Input: n = 2, k = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * Example 3:
 *
 * Input: n = 2, k = 0
 * Output: [11,22,33,44,55,66,77,88,99]
 * Example 4:
 *
 * Input: n = 2, k = 2
 * Output: [13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 *
 *
 * Constraints:
 *
 * 2 <= n <= 9
 * 0 <= k <= 9
 */
public class LeetCode967 {
    List<Integer> res = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            dfs(n, 0, k, i);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int n, int d, int k, int num) {
        if (d == n) {
            res.add(num);
            return;
        }

        int last = num % 10;
        if (last + k <= 9) {
            dfs(n, d + 1, k, num * 10 + last + k);
        }
        if (last - k >= 0 && k != 0) {
            dfs(n, d + 1, k, num * 10 + last - k);
        }
    }

}
