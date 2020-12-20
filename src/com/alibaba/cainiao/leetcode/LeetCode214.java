package com.alibaba.cainiao.leetcode;

/**
 * 214. Shortest Palindrome
 * Hard
 *
 *
 * Given a string s, you can convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: "dcbabcd"
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of lowercase English letters only.
 */
public class LeetCode214 {

    // 头插法
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int pos = 0;
        while (true) {
            if (isPalindrome(sb)) {
                return sb.toString();
            } else {
                // 不断插入字符,一定会结束
                sb.insert(pos, sb.charAt(s.length() - 1 - pos));
                pos++;
            }
        }
    }

    private boolean isPalindrome(StringBuilder sb) {
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) == sb.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }

}
