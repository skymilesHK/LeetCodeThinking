package com.alibaba.cainiao.leetcode;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * 示例 1：
 *
 * 输入：arr = [2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：arr = [3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [0,3,2,1]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 */
public class LeetCode941 {
    public boolean validMountainArray(int[] a) {
        int n = a.length;
        if (n < 3) {
            return false;
        }

        int i = 0, j = n - 1;
        //从左边往右边找，一直找到山峰为止
        while (i + 1 < n && a[i] < a[i + 1]) {
            i++;
        }

        //从右边往左边找，一直找到山峰为止
        while (j - 1 >= 0 && a[j - 1] > a[j]) {
            j--;
        }

        //判断从左边和从右边找的山峰是不是同一个
        return i > 0 && j < n - 1 && i == j;
    }
}
