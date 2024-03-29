package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 494. Target Sum
 * Medium
 *
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 *
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 *
 * Constraints:
 *
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class LeetCode494 {

    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int S, int u, int sum) {
        if (u == nums.length) {
            if (S == sum) {
                res++;
            }
            return;
        }

        // +
        dfs(nums, S, u + 1, sum + nums[u]);
        // -
        dfs(nums, S, u + 1, sum - nums[u]);
    }

}
