package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 66. Plus One
 * Easy
 *
 * 1973
 *
 * 2834
 *
 * Add to List
 *
 * Share
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class LeetCode66 {

    // 类似高精度加法的原理， 因为是+1，所以把t改成1
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (n == 0) {
            return new int[] {1};
        }

        List<Integer> A = new ArrayList<>(n);
        for (int i = n - 1; i >= 0; i--) {
            A.add(digits[i]);
        }

        add(A);
        int[] res = new int[n];
        for(int i = 0;i < A.size();i ++) {
            res[i] = A.get(A.size() - i - 1);
        }
        return res;
    }

    private void add(List<Integer> A) {
        int t = 1;
        for (int i = 0; i < A.size(); i++) {
            t += A.get(i);
            A.set(i, t % 10);
            t /= 10;
        }

        if (t > 0) {
            A.add(t);
        }
    }
}
