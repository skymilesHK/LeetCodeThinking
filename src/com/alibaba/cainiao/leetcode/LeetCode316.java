package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 316. Remove Duplicate Letters
 * Medium
 *
 * 2250
 *
 * 169
 *
 * Add to List
 *
 * Share
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */
public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>(s.length());
        Map<Character, Boolean> inRes = new HashMap<>(s.length());
        Map<Character, Integer> lastOccur = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            lastOccur.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (inRes.get(ch) != null && inRes.get(ch)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && lastOccur.get(stack.peek()) != null && lastOccur.get(stack.peek()) > i) {
                inRes.put(stack.peek(), false);
                stack.pop();
            }
            stack.push(ch);
            inRes.put(ch, true);
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (Character ch : stack) {
            sb.insert(0, ch);
        }

        return sb.toString();
    }
}
