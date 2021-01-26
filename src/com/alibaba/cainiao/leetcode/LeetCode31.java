package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * Medium
 *
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class LeetCode31 {
    // 1       2         7        4          3          0
    //      replaceIdx                                 lgIdx
    // 1       3         7        4          2          0
    // 1       3         0        2          4          7
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        int replaceIdx = n - 2;
        while (replaceIdx >= 0) {
            if (nums[replaceIdx] < nums[replaceIdx + 1]) {
                break;
            }
            replaceIdx--;
        }

        if (replaceIdx < 0) {
            Arrays.sort(nums);
            return;
        }

        // replace curr number with the next lowest greater number
        int lgIdx = replaceIdx + 1;
        while (lgIdx < n && nums[lgIdx] > nums[replaceIdx]) {
            lgIdx++;
        }

        swap(nums, replaceIdx, lgIdx - 1);
        reverse(nums, replaceIdx + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
