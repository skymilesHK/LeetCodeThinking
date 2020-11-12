package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{};
        }

        int res[] = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0, j = 0; i < n; i++) {
            // 检查滑动窗口
            while (!queue.isEmpty() && i - k + 1 > queue.getFirst()) {
                queue.pollFirst();
            }

            // 检查单调性,递减队列
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.pollLast();
            }

            // 新的符合条件的数字入队列
            queue.offer(i);

            // 前k个不计入结果数组
            if (i - k + 1 >= 0) {
                res[j++] = nums[queue.getFirst()];
            }
        }

        return res;
    }
}
