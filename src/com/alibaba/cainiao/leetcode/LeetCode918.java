package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode918 {
    // 输入：[1,-2,3,-2]
    // 输出：3
    // 解释：从子数组 [3] 得到最大和 3
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int res = A[0];
        int[] sum = new int[n + n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            if (i <= n) {
                sum[i] = sum[i - 1] + A[i - 1];
            } else {
                sum[i] = sum[i - 1] + A[i - n - 1];
            }
        }

        // 输入：[1,-2,3,-2,1,-2,3,-2]
        // 输出：3
        //sum:[0,1,-1,2,0,1,-1,2,0]
        Deque<Integer> q = new ArrayDeque<>(n);
        q.offer(0);
        for (int i = 1; i <= 2 * n; i++) {
            while (!q.isEmpty() && i - q.getFirst() > n) {
                q.pollFirst();
            }

            res = Math.max(res, sum[i] - sum[q.getFirst()]);

            while (!q.isEmpty() && sum[i] <= sum[q.getLast()]) {
                q.pollLast();
            }

            q.add(i);
        }

        return res;

    }
}
