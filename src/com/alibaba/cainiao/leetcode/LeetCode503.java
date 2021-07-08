package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 */
public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[] {};
        }

        int m = n + n;
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            if (i < n) {
                nums2[i] = nums[i];
            } else {
                nums2[i] = nums[i - n];
            }
        }

        int[] res = new int[n];
        // 递减栈
        Deque<Integer> stack = new ArrayDeque<>(m);
        for (int i = m - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            // 前n个记录答案
            if (i < n) {
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }

            stack.push(nums2[i]);
        }

        return res;
    }
}
