package com.alibaba.cainiao.leetcode;

public class LeetCode540 {

    public int singleNonDuplicate(int[] nums) {
        int[] a = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }

        a[nums.length] = nums[nums.length - 1] + 1;

        int start = 0, end = a.length / 2 - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid * 2] != nums[mid * 2 + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (a[start * 2] != a[start * 2 + 1]) {
            return a[start * 2];
        } else {
            return a[end * 2];
        }
    }
}
