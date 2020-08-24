package com.alibaba.cainiao.leetcode;

/**
 * 72. Edit Distance
 * Hard
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class LeetCode72 {

    // https://pan.baidu.com/play/video#/video?path=%2FVideo%2F%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%2F07-%E4%B9%9D%E7%AB%A0%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%2F%E4%B9%9D%E7%AB%A0%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%926_%E5%8F%8C%E5%BA%8F%E5%88%97%E5%9E%8B.mp4&t=-1

    public int minDistance(String a, String b) {

        int m = a.length();
        int n = b.length();

        // 表示a的前i个字符和b的前j个字符最小的编辑距离
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0x3f3f3f3f;
                if (i == 0) {
                    dp[0][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][0] = i;
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
