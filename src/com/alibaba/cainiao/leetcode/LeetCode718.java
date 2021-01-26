package com.alibaba.cainiao.leetcode;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class LeetCode718 {

    public int findLength(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;
        if (aLen == 0 || bLen == 0) {
            return 0;
        }

        // 设 dp(i,j) 表示以 A[i] 和 B[j] 结尾的最长公共子数组的长度
        int[][] dp = new int[aLen][bLen];

        for (int j = 0; j < bLen; j++) {
            dp[0][j] = (A[0] == B[j]) ? 1 : 0;
        }

        for (int i = 0; i < aLen; i++) {
            dp[i][0] = (A[i] == B[0]) ? 1 : 0;
        }

        int res = 0;
        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                // 统计
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }

}
