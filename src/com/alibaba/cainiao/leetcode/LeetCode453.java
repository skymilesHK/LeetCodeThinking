package com.alibaba.cainiao.leetcode;

/**
 * 453. Minimum Moves to Equal Array Elements
 * Easy
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class LeetCode453 {

    public int minMoves(int[] nums) {
        int min = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - min;
        }
        return res;
    }

}
