package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number
 * Medium
 *
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 */
public class LeetCode611 {

    // a + b > c
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        for (int c = n - 1; c >= 2; c--) {
            int b = c - 1;
            int a = 0;
            while (b > a) {
                if (nums[a] + nums[b] > nums[c]) {
                    res += (b - a);
                    b--;
                } else {
                    a++;
                }
            }
        }

        return res;
    }

}
