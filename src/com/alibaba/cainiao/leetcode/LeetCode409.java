package com.alibaba.cainiao.leetcode;

/**
 * 409. Longest Palindrome
 * Easy
 *
 *
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Example 3:
 *
 * Input: s = "bb"
 * Output: 2
 */
public class LeetCode409 {

    int[] frequency = new int[128];

    public int longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        for (int i = 0; i < n; i++) {
            frequency[s.charAt(i)]++;
        }

        int res = 0;
        boolean flag = false;
        for (int i = 0; i < 128; i++) {
            if (frequency[i] == 0) {
                continue;
            }

            res += frequency[i];
            if (frequency[i] % 2 == 1) {
                res -= 1;
                flag = true;
            }
        }

        return flag ? res + 1 : res;
    }

}
