package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Medium
 *
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];   // 最小的总和,赋予一个初始值
        int gap = Math.abs(closestSum - target);        // 和target的最小差值,赋予一个初始值
        for (int i = 0; i < n - 2; i++) {
            // skip duplicate
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int newSum = nums[i] + nums[j] + nums[k];
                int newGap = Math.abs(newSum - target);
                if (newGap < gap) {
                    gap = newGap;          // 更新和target的最小差值
                    closestSum = newSum;   // 更新最小的总和
                }

                if (newSum < target) {
                    j++;
                    // skip duplicate
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (newSum > target) {
                    k--;
                    // skip duplicate
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else {
                    return target;
                }
            }
        }
        return closestSum;
    }

}
