package com.alibaba.cainiao.leetcode;

/**
 * 719. Find K-th Smallest Pair Distance
 *
 *
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
 *
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Note:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class LeetCode719 {

    // https://www.cnblogs.com/grandyang/p/8627783.html
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int N = 1000000;
        // index 是 两数距离差，value是两数距离差出现的次数
        int[] bucket = new int[N];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ++bucket[Math.abs(nums[j] - nums[i])];
            }
        }

        for (int i = 0; i < N; i++) {
            if (bucket[i] >= k) {
                return i;
            } else {
                k -= bucket[i];
            }
        }

        return -1;
    }

}
