package com.alibaba.cainiao.leetcode;

/**
 * 169. Majority Element
 * Easy
 *
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 */
public class LeetCode169 {
    // 记住这个做法 , 本质=找某个数，其出现的次数比其他数出现的次数加起来都多
    // https://www.acwing.com/video/1548/
    // candidate是当前库存最多的数字，candidateCnt是库存最多的数字出现的次数
    public int majorityElement(int[] nums) {
        int candi = nums[0];
        int candiCnt = 0;
        for (int x : nums) {
            if (candiCnt == 0) {
                candi = x;
                candiCnt = 1;
            } else if (x == candi) {
                candiCnt++;
            } else {
                candiCnt--;
            }
        }

        return candi;
    }
}
