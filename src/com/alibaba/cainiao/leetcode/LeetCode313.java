package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 313. Super Ugly Number
 * Medium
 *
 *
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 *
 * Example:
 *
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 *              super ugly numbers given primes = [2,7,13,19] of size 4.
 * Note:
 *
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class LeetCode313 {

    // https://leetcode-cn.com/problems/super-ugly-number/solution/chao-ji-chou-shu-yu-264ti-yi-zhi-duo-zhi-zhen-si-x/
    // 实际上pi的含义是有资格同i相乘的最小丑数的位置。
    // 这里资格指的是：如果一个丑数nums[pi]通过乘以i可以得到下一个丑数，那么这个丑数nums[pi]就永远失去了同i相乘的资格（没有必要再乘了）

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;

        //总体思路与264题一致，只是将因数由多个变量变为数组元素

        //该数组用于存放primes数组中每个元素需要乘的最小丑数索引
        int k = primes.length;
        int[] index = new int[k];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            //将最小丑数存放在dp数组中
            for (int j = 0; j < k; j++) {
                if (min > res[index[j]] * primes[j]) {
                    min = res[index[j]] * primes[j];
                }
                res[i] = min;
            }

            //将对应primes数组中的元素索引 + 1
            for (int j = 0; j < k; j++) {
                if (min == res[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }

        return res[n - 1];
    }

}
