package com.alibaba.cainiao.leetcode;

/**
 * 115. Distinct Subsequences
 * Hard
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It's guaranteed the answer fits on a 32-bit signed integer.
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
public class LeetCode115 {

    // https://leetcode-cn.com/problems/distinct-subsequences/solution/dong-tai-gui-hua-by-powcai-5/

    public int numDistinct(String s, String t) {
        // 定义dp[i][j]表示num of substring of s[1][j] equals t[1][i]
        // if t[i] == s[j]:
        //  dp[i][j] = dp[i-1][j-1]  # match s[j], t[i]
        //           + dp[i][j-1]    # skip  s[j]
        // else:
        //  dp[i][j] = dp[i][j-1]    # skip  s[j]

        int sLen = s.length();
        int tLen = t.length();
        if (tLen > sLen) {
            return 0;
        }

        s = "!" + s;
        t = "!" + t;
        int[][] dp = new int[tLen + 1][sLen + 1];

        for (int i = 0; i <= tLen; i++) {
            for (int j = 0; j <= sLen; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }

                // 把第1列填充成1，因为t是空, 因为空集是所有字符串子集
                if (i == 0) {
                    dp[0][j] = 1;
                    continue;
                }

                // s 为空,这样组成 t 个数当然为 0了
                if (j == 0) {
                    dp[i][0] = 0;
                    continue;
                }

                if (t.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[tLen][sLen];
    }

}
