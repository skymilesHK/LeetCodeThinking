package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 556. Next Greater Element III
 * Medium
 *
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
 *
 * Example 1:
 *
 * Input: 12
 * Output: 21
 *
 *
 * Example 2:
 *
 * Input: 21
 * Output: -1
 */
public class LeetCode556 {

    public int nextGreaterElement(int n) {
        // 将一个多位整数转换为数组
        int[] nums = transfer(n);
        if (nums.length <= 1) {
            return -1;
        }

        int replaceIdx = nums.length - 2;
        while (replaceIdx >= 0) {
            if (nums[replaceIdx] < nums[replaceIdx + 1]) {
                break;
            }
            replaceIdx--;
        }

        // 全逆序
        if (replaceIdx < 0) {
            return -1;
        }

        // replace curr number with the next (closest) greater number
        int cgIdx = replaceIdx + 1;
        while (cgIdx < nums.length && nums[cgIdx] > nums[replaceIdx]) {
            cgIdx++;
        }

        swap(nums, replaceIdx, cgIdx - 1);
        reverse(nums, replaceIdx + 1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum * 10 + nums[i];
        }

        return sum > n ? sum : -1;
    }

    public int[] transfer(int n) {
        String str = String.valueOf(n);
        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            char ch = str.charAt(i);
            arr[i] = ch - '0';
        }
        return arr;
    }

    private void reverse(int[] nums, int idx) {
        int i = idx, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
