package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Medium
 *
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int target = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            // skip duplication
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                    // skip duplication
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                    // skip duplication
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // skip duplication
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }

}
