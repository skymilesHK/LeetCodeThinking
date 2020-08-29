package com.alibaba.cainiao.leetcode;

/**
 * 583. Delete Operation for Two Strings
 * Medium
 *
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 */
public class LeetCode583 {

    public int minDistance(String word1, String word2) {

        // 这题目其实就是最长公共子序列
        int n1 = word1.length();
        int n2 = word2.length();
        // dp[i][j] 表示第一个字符串的前 ii 个字符和第二个字符串的前 jj 个字符的最长公共子序列长度(最后一个字符i，j不一定必选)
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 需要删除的数字 = word1长度-最长公共子序列长度 + word2长度-最长公共子序列长度
        return n1 - dp[n1][n2] + n2 - dp[n1][n2];
    }

}
