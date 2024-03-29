package com.alibaba.cainiao.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class LeetCode581 {

    // https://www.acwing.com/video/2040/
    public int findUnsortedSubarray(int[] nums) {
        // [2, 6, 4, 8, 10, 9, 15]
        // [2, 4, 6, 8, 9, 10, 15]
        int n = nums.length;
        int[] sortNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortNums);
        int left = 0, right = n - 1;
        while (left < n && sortNums[left] == nums[left]) {
            left++;
        }

        while (right >= 0 && sortNums[right] == nums[right]) {
            right--;
        }

        return Math.max(right - left + 1, 0);
    }

}
