package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * Easy
 *
 *
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 *
 * Note: You may assume the string contains only lowercase English letters.
 */
public class LeetCode387 {

    public int firstUniqChar(String s) {
        int n = s.length();
        if (n == 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(s.charAt(i), 0) == 1) {
                return i;
            }
        }

        return -1;
    }

}
