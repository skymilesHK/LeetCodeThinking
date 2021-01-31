package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 532. K-diff Pairs in an Array
 * Medium
 *
 *
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 *
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Example 4:
 *
 * Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
 * Output: 2
 * Example 5:
 *
 * Input: nums = [-1,-2,-3], k = 1
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */
public class LeetCode532 {

    // nums = [3, 1, 4, 1, 5], k = 2
    // nums = [1, 1, 3, 4, 5], k = 2
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == k ? 1 : 0;
        }

        Arrays.sort(nums);
        int l = 0, r = 1, res = 0;
        // nums[l]和nums[r]差距<= k,r直接++
        while (r < n) {
            // 相同的选最后一个计数
            while (r + 1 < n && nums[r] == nums[r + 1]) {
                r++;
            }

            while (l < r && nums[r] - nums[l] > k) {
                l++;
            }

            if (l < r && nums[r] - nums[l] == k) {
                res++;
            }
            r++;
        }

        return res;
    }

}
