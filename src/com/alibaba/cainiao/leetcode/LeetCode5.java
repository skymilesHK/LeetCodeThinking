package com.alibaba.cainiao.leetcode;

/**
 * 5. Longest Palindromic Substring
 * Medium
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LeetCode5 {


    // 回文串就是正着读和反着读都一样的字符串。
    // https://leetcode-cn.com/problems/longest-palindromic-substring/solution/5-zui-chang-hui-wen-zi-chuan-dong-tai-gui-hua-jie-/    注意填表顺序
    // https://www.youtube.com/watch?v=ZnzvU03HtYk  注意填表顺序

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int n = s.length();
        int maxLen = 0, start = 0, end = 0;
        // dp[i][j]表示下标为i, j之间的字符串是否为回文
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = n - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }

        }

        return s.substring(start, end + 1);
    }

}
