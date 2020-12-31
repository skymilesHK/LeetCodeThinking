package com.alibaba.cainiao.leetcode;

/**
 * 152. Maximum Product Subarray
 * Medium
 *
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        // 表示到i为止的乘积
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            max = Math.max(x, Math.max(max * x, min * x));
            min = Math.min(x, Math.max(max * x, min * x));
            res = Math.max(res, max);
        }
        return res;
    }

}
