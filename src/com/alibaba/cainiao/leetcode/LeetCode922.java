package com.alibaba.cainiao.leetcode;

/**
 * 922. Sort Array By Parity II
 * Easy
 *
 * 944
 *
 * 57
 *
 * Add to List
 *
 * Share
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 *
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 *
 * Return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * Example 2:
 *
 * Input: nums = [2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 2 * 104
 * nums.length is even.
 * Half of the integers in nums are even.
 * 0 <= nums[i] <= 1000
 */
public class LeetCode922 {

    public int[] sortArrayByParityII(int[] A) {
        int evenIdx = 0;
        int oddIdx = 1;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0) {
                // 偶数
                res[evenIdx] = A[i];
                evenIdx += 2;
            } else {
                res[oddIdx] = A[i];
                oddIdx += 2;
            }
        }

        return res;
    }

}
