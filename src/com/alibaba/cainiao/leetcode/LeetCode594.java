package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 594. Longest Harmonious Subsequence
 * Easy
 *
 *
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 */
public class LeetCode594 {

    public int findLHS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int res = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer k = entry.getKey();
            if (map.containsKey(k + 1)) {
                res = Math.max(res, map.get(k + 1) + map.get(k));
            }
        }

        return res;
    }

}
