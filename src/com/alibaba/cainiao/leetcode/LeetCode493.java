package com.alibaba.cainiao.leetcode;

/**
 * 493. Reverse Pairs
 * Hard
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 *
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 *
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 */
public class LeetCode493 {

    int res = 0, n = 0;
    public int reversePairs(int[] A) {
        n = A.length;
        if (n == 0) {
            return 0;
        }

        mergeSort(A, 0, n - 1);
        return res;
    }

    private void mergeSort(int[] A, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(A, l, mid);
        mergeSort(A, mid + 1, r);
        merge(A, l , mid, r);
    }

    private void merge(int[] A, int l, int mid, int r) {
        // 临时合并数组长度
        int[] nums = new int[r - l + 1];

        // 合并的第一个数组起始位置p
        // 合并的第二个数组起始位置q
        int p = l, q = mid + 1, idx = 0;
        while (p <= mid && q <= r) {
            if ((long) A[p] > (long) (A[q] * 2)) {
                res += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }

        // 这里是正常的归并
        p = l;
        q = mid + 1;
        while (p <= mid && q <= r) {
            if (A[p] <= A[q]) {
                nums[idx++] = A[p++];
            } else {
                nums[idx++] = A[q++];
            }
        }

        while (p <= mid) {
            nums[idx++] = A[p++];
        }

        while (q <= r) {
            nums[idx++] = A[q++];
        }

        System.arraycopy(nums, 0, A, l, r - l + 1);
    }

}
