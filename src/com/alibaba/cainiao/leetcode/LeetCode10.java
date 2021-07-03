package com.alibaba.cainiao.leetcode;

/**
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class LeetCode10 {
    // 看视频的解析图
    // https://www.youtube.com/watch?v=DqhPJ8MzDKM&t=606s
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = p.length();
        int n = s.length();
        // 表示p的前i个字串和s的前j个是否匹配
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // 初始化第一行，第一列
        //for (int j = 1; j <= n; ++j) {
        //    dp[0][j] = false;
        //}

        for (int i = 1; i <= m; ++i) {
            // * 记号不能在p的首位
            if (i == 1) {
                dp[i][0] = false;
            } else {
                if (p.charAt(i - 1) == '*') {
                    dp[i][0] = dp[i - 2][0];
                } else {
                    dp[i][0] = false;
                }
            }
        }

        // 循环p字串
        for (int i = 1; i <= m; i++) {
            // 循环s字串
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    // *这个字符之前的一个字符被当作多次
                    if (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 2][j];
                    } else {
                        dp[i][j] = dp[i - 2][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
