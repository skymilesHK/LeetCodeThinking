package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * Medium
 *
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class LeetCode442 {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>(n);
        if (n <= 1) {
            return res;
        }

        for (int x : nums) {
            int idx = Math.abs(x) - 1;
            nums[idx] *= -1;
            if (nums[idx] > 0) {
                res.add(x);
            }
        }

        return res;
    }

}
