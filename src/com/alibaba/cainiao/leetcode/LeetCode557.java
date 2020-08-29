package com.alibaba.cainiao.leetcode;

/**
 * 557. Reverse Words in a String III
 * Easy
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class LeetCode557 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] split = s.split("\\s+");
        StringBuilder sb = null;
        StringBuilder res = new StringBuilder();
        for (String word : split) {
            sb = new StringBuilder(word);
            res.append(sb.reverse().append(' '));
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

}
