package com.alibaba.cainiao.leetcode;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class LeetCode459 {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int n = s.length();
        StringBuilder sb = null;
        for (int l = n / 2; l >= 0; l--) {
            // 如果当前长度能被总长度整除，说明有机会分成若干个子字符串
            if (n % l == 0) {
                String sub = s.substring(0, l);
                int part = n / l;
                sb = new StringBuilder();
                for (int i = 0; i < part; i++) {
                    sb.append(sub);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}
