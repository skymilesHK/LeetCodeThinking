package com.alibaba.cainiao.leetcode;

/**
 * 14. Longest Common Prefix
 * Easy
 *
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String standard = strs[0];
        for (int i = 0; i < standard.length(); i++) {
            char ch = standard.charAt(i);
            for (String str : strs) {
                if (str.equals(standard)) {
                    continue;
                }

                // 可以停下来了
                if (i >= str.length() || ch != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }

        return sb.toString();
    }

}
