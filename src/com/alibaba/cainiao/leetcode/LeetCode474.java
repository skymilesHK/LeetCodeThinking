package com.alibaba.cainiao.leetcode;

/**
 * 474. 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 */
public class LeetCode474 {

    public int findMaxForm(String[] A, int m, int n) {
        int len = A.length;
        // dp[i][j][k]为前i个01串最多能有多少个被j个0和k个1组成
        // 九章动态规划6 01:48分钟, 有点类似二元背包
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        // init
        // for (int j = 0; j <= m; j++) {
        //     for (int k = 0; k <= n; k++) {
        //         dp[0][j][k] = 0;
        //     }
        // }

        int n0 = 0, n1 = 0;
        for (int i = 1; i <= len; i++) {
            n0 = 0;
            n1 = 0;
            // 这个循环统计每个串1,0个数
            for (int j = 0; j < A[i - 1].length(); j++) {
                if (A[i - 1].charAt(j) == '0') {
                    n0++;
                } else {
                    n1++;
                }
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= n0 && k >= n1) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - n0][k - n1] + 1);
                    }
                }
            }
        }

        return dp[len][m][n];
    }
}
