package com.alibaba.cainiao.leetcode;

/**
 * Student Attendance Record II
 * 552. 学生出勤记录 II
 * 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。
 *
 * 学生出勤记录是只包含以下三个字符的字符串：
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: 8
 * 解释：
 * 有8个长度为2的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数超过一次。
 * 注意：n 的值不会超过100000。
 */
public class LeetCode552 {
    final int MOD = 1000000007;
    // https://www.acwing.com/video/2014/
    public int checkRecord(int n) {
        // dp(i,j,k)  表示已经完成了前 i 次出勤记录，包含 j 个 ‘A‘ 和末尾连续 k 个 ‘L‘ 的方案数。初始时 f(0,0,0)=1。
        // i 的范围[0, n-1], j的范围[0,1], k的范围[0,2]
        int[][][] dp = new int[100001][2][3];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            // j表示A的数量
            for (int j = 0; j <= 1; j++) {
                // k表示L的数量
                for (int k = 0; k <= 2; k++) {
                    // 1.选p, dp[i][j][k]转移过来
                    dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][k]) % MOD;

                    // 2.选A
                    if (j == 0) {
                        dp[i + 1][j + 1][0] = (dp[i + 1][j + 1][0] + dp[i][j][k]) % MOD;
                    }

                    // 3.选L
                    if (k < 2) {
                        dp[i + 1][j][k + 1] = (dp[i + 1][j][k + 1] + dp[i][j][k]) % MOD;
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                res = (res + dp[n][j][k]) % MOD;
            }
        }
        return res;
    }
}
