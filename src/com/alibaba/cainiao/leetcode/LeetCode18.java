package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * Medium
 *
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class LeetCode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {
            return res;
        }

        Arrays.sort(nums);
        for (int u = 0; u < n - 3; u++) {
            if (u > 0 && nums[u] == nums[u - 1]) {
                continue;
            }

            for (int i = u + 1; i < n - 2; i++) {
                if (i > u + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int sum = nums[u] + nums[i] + nums[j] + nums[k];
                    if (sum < target) {
                        j++;
                        // skip
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    } else if (sum > target) {
                        k--;
                        // skip
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else {
                        res.add(Arrays.asList(nums[u], nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        // skip
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                }
            }
        }
        return res;
    }

}
