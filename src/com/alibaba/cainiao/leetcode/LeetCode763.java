package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class LeetCode763 {

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        Arrays.fill(res, 0x3f3f3f3f);
        for (int i = 0, j = -1; i < n; i++) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != -1) {
                res[i] = i - j;
            }
        }

        for (int i = n - 1, j = n; i >= 0; i--) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != n) {
                res[i] = Math.min(res[i], j - i);
            }
        }

        return res;
    }

}
