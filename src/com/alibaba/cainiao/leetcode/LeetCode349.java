package com.alibaba.cainiao.leetcode;

import java.util.HashSet;

/**
 * 349. Intersection of Two Arrays
 * Easy
 *
 * 1232
 *
 * 1463
 *
 * Add to List
 *
 * Share
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>(nums1.length);
        HashSet<Integer> res = new HashSet<>(nums1.length);
        for (int n1 : nums1) {
            set.add(n1);
        }

        for (int n2 : nums2) {
            if (set.contains(n2)) {
                res.add(n2);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
