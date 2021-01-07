package com.alibaba.cainiao.leetcode;

/**
 * 414. Third Maximum Number
 * Easy
 *
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class LeetCode414{

    // https://leetcode-cn.com/problems/third-maximum-number/solution/1msda-bai-93jian-yi-bu-yao-pai-xu-by-wan-rhqu/
    public int thirdMax(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int x : nums) {
            if (x > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = x;
            } else if (x == firstMax) {
                continue;
            } else if (x > secondMax) {
                thirdMax = secondMax;
                secondMax = x;
            } else if (x == secondMax) {
                continue;
            } else if (x > thirdMax) {
                thirdMax = x;
            } else if (x == thirdMax) {
                continue;
            }
        }

        return thirdMax == Long.MIN_VALUE ? (int) firstMax : (int) thirdMax;
    }

}
