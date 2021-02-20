package com.alibaba.cainiao.leetcode;

import java.util.Collection;
import java.util.TreeMap;

/**
 * 327. Count of Range Sum
 * Hard
 *
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 *
 * Example:
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10^4
 */
public class LeetCode327 {

    // https://blog.csdn.net/jmspan/article/details/51266931
    int res = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        long[] preSums = new long[n];
        preSums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSums[i] = preSums[i - 1] + nums[i];
        }

        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            // 单独本身
            if (preSums[i] >= lower && preSums[i] <= upper) {
                res++;
            }

            // nums[i] - upper <= x - sums[j] <= nums[i] - lower
            // sum[i] - upper <= x <= sum[i] - lower
            for (Integer c : treeMap.subMap(preSums[i] - upper, true, preSums[i] - lower, true).values()) {
                res += c;
            }

            Integer count = treeMap.get(preSums[i]);
            if (count == null || count == 0) {
                count = 1;
            } else {
                count++;
            }
            treeMap.put(preSums[i], count);
        }

        return res;
    }

}
