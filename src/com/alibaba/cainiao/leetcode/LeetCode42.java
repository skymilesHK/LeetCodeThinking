package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class LeetCode42 {

    // https://www.acwing.com/solution/LeetCode/content/121/   代码
    // https://www.bilibili.com/video/BV1t4411o7i6 讲解
    // Input: [6,4,3,0,1,5]
    // Output: 12
    // 找左边第一个大于当前柱子的index，然后分层加上面积
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }

        int res = 0;
        // 递减栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // lastH是上一个stack头部元素的Height
            int lastH = 0;
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer t = stack.pop();
                res += (i - t - 1) * (height[t] - lastH);
                lastH = height[t];
            }

            // 最后一层
            if (!stack.isEmpty()) {
                res += (i - stack.peek() - 1) * (height[i] - lastH);
            }
            stack.push(i);
        }

        return res;
    }

}
