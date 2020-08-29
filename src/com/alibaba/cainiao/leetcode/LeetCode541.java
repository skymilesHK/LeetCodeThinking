package com.alibaba.cainiao.leetcode;

/**
 * 541. Reverse String II
 * Easy
 *
 *
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class LeetCode541 {

    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            for (int st = i, ed = Math.min(s.length() - 1, i + k - 1); st < ed; st++, ed--) {
                char t = array[st];
                array[st] = array[ed];
                array[ed] = t;
            }
        }

        for (int i = 0; i < array.length; i++) {
            res.append(array[i]);
        }
        return res.toString();
    }

}
