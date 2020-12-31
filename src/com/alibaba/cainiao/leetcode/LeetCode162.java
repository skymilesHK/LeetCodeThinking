package com.alibaba.cainiao.leetcode;

/**
 * 162. Find Peak Element
 * Medium
 *
 *
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 *
 *
 * Follow up: Could you implement a solution with logarithmic complexity?
 */
public class LeetCode162 {

    // https://www.acwing.com/video/1532/
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int start = 0, end = n - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] >= nums[end]) {
            return start;
        } else {
            return end;
        }
    }
}
