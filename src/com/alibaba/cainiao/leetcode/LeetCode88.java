package com.alibaba.cainiao.leetcode;

/**
 * 88. Merge Sorted Array
 * Easy
 *
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 *
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class LeetCode88 {

    // https://www.bilibili.com/video/av64330434
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1有足够的空间存nums2
        int end1 = m - 1, end2 = n - 1, k = m + n - 1;
        while (end1 >= 0 && end2 >= 0) {
            if (nums1[end1] < nums2[end2]) {
                nums1[k--] = nums2[end2--];
            } else {
                nums1[k--] = nums1[end1--];
            }
        }

        // nums2还有剩余
        while (end2 >= 0) {
            nums1[k--] = nums2[end2--];
        }
        // nums1还有剩余，本来需要写个循环，但是不循环也没事，答案已经有序了
    }

}
