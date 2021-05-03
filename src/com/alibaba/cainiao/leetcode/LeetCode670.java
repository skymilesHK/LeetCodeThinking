package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 670. Maximum Swap
 * Medium
 *
 * 1309
 *
 * 81
 *
 * Add to List
 *
 * Share
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 */
public class LeetCode670 {
    // https://www.acwing.com/video/2451/
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        for (int i = 0, cnt = 0; i < chars.length - 1; i++) {
            // 找第一个逆序
            if (chars[i] < chars[i + 1]) {
                if (cnt > 1) {
                    break;
                }

                cnt++;
                int k = i + 1;
                for (int j = k; j < chars.length; j++) {
                    if (chars[j] >= chars[k]) {
                        k = j;
                    }
                }

                for (int j = 0; j < k; j++) {
                    if (chars[j] < chars[k]) {
                        swap(chars, j, k);
                        break;
                    }
                }
            }
        }

        return Integer.parseInt(new String(chars));
    }

    private void swap(char[] chars, int i, int j) {
        if (i != j) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
    }
}
