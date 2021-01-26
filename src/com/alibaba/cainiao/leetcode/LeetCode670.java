package com.alibaba.cainiao.leetcode;

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
    // https://leetcode-cn.com/problems/maximum-swap/solution/0ms-100-bu-miao-da-wo-by-wang-xue-lei-2-iyz9/
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        // maxIdx是最大idx，maxIdxArr是每个数字左边出现更大下标的数组
        int maxIdx = chars.length - 1;
        int[] maxIdxArr = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > chars[maxIdx]) {
                maxIdx = i;
            }
            maxIdxArr[i] = maxIdx;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[maxIdxArr[i]] > chars[i]) {
                char temp = chars[maxIdxArr[i]];
                chars[maxIdxArr[i]] = chars[i];
                chars[i] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
