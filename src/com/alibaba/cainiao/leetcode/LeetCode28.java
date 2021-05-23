package com.alibaba.cainiao.leetcode;

/**
 * 28. Implement strStr()
 * Easy
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 */
public class LeetCode28 {

    // 输入：t = "hello", s = "ll"
    // 输出：2
    // https://www.youtube.com/watch?v=OhPtAQtfsuM
    public int strStr(String t, String s) {
        if (t.length() < s.length()) {
            return -1;
        }
        if (s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < t.length() - s.length() + 1; i++) {
            if (t.charAt(i) == s.charAt(0)) {
                int j = 0;
                while (i + j < t.length() && j < s.length() && t.charAt(i + j) == s.charAt(j)) {
                    j++;
                }

                if (j == s.length()) {
                    return i;
                }
            }
        }

        return -1;
    }
}
