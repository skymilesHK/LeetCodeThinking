package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1. Two Sum
 * Easy
 *
 *
 * Given an array of integers nums and and integer target, return the indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1]
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[] {};
        }
        Map <Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            map.put(cur, i);
            if (map.containsKey(target - cur)) {
                return new int[] {i, map.get(target - cur)};
            }
        }

        return new int[] {};
    }

}
