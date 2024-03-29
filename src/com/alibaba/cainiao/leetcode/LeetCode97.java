package com.alibaba.cainiao.leetcode;

/**
 * 97. Interleaving String
 * Hard
 *
 * 1542
 *
 * 90
 *
 * Add to List
 *
 * Share
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class LeetCode97 {

    // https://www.acwing.com/video/1442/
    // https://pan.baidu.com/play/video#/video?path=%2FVideo%2F%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%2F07-%E4%B9%9D%E7%AB%A0%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%2F%E4%B9%9D%E7%AB%A0%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%926_%E5%8F%8C%E5%BA%8F%E5%88%97%E5%9E%8B.mp4&t=-1
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();
        if (s1Len + s2Len != s3Len) {
            return false;
        }

        // dp[i][j]表示s3的前i+j个字符是否由s1的前i个字符+s2的前j个字符交错而成
        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1Len; i++) {
            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]);
        }

        for (int j = 1; j <= s2Len; j++) {
            dp[0][j] = (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]);
        }

        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                // s3最后一个字符和s1最后一个字符相等
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                }

                // s3最后一个字符和s2最后一个字符相等
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[s1Len][s2Len];
    }

}
