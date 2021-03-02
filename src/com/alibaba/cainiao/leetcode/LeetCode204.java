package com.alibaba.cainiao.leetcode;

/**
 * 204. Count Primes
 * Easy
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 * Example 3:
 *
 * Input: n = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= n <= 5 * 106
 */
public class LeetCode204 {
    int cnt = 0;
    int[] primes = null;
    boolean[] st = null;
    public int countPrimes(int n) {
        primes = new int[n];
        st = new boolean[n];
        getPrimeCnt(n);
        return cnt;
    }

    private void getPrimeCnt(int n) {
        for (int i = 2; i < n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                for (int j = i; j <= n; j = j + i) {
                    st[j] = true;
                }
            }
        }
    }
}
