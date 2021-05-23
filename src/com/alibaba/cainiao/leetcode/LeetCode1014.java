package com.alibaba.cainiao.leetcode;

public class LeetCode1014 {
    // https://www.bilibili.com/video/BV12f4y1y7H4?from=search&seid=1125131411828347447
    public int maxScoreSightseeingPair(int[] A) {
        int maxi = A[0] + 0;
        int max = 0;

        for (int j = 1, i = 1; j < A.length; j++) {
            max = Math.max(max, maxi + A[j] - j);
            maxi = Math.max(maxi, A[j] + j);
        }

        return max;
    }
}
