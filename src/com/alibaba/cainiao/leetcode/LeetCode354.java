package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes
 * Hard
 *
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class LeetCode354 {
    // https://www.acwing.com/video/1741/
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        //排序，按照宽的升序排序(如果宽相同的话，则按高的升序排序)
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[0];
            }
        });

        int res = 1;
        //dp[i]: 以i结尾的(在外层是第i个信封)能装下的最大值
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

}
