package com.alibaba.cainiao.leetcode;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;

        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
