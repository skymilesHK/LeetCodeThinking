package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 * Medium
 *
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class LeetCode438 {

    List<Integer> res = new ArrayList<>();

    // 超时
//    public List<Integer> findAnagrams(String s, String p) {
//        int pLen = p.length();
//        int sLen = s.length();
//        if (sLen < pLen) {
//            return res;
//        }
//
//        Map<Character, Integer> pMap = new HashMap<>();
//        for (int i = 0; i < pLen; i++) {
//            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
//        }
//
//        for (int i = 0; i < sLen - pLen + 1; i++) {
//            String substring = s.substring(i, i + pLen);
//            Map<Character, Integer> subMap = new HashMap<>();
//            for (int j = 0; j < substring.length(); j++) {
//                subMap.put(substring.charAt(j), subMap.getOrDefault(substring.charAt(j), 0) + 1);
//            }
//            if (subMap.equals(pMap)) {
//                res.add(i);
//            }
//        }
//
//        return res;
//    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        int[] frequencyP = new int[26];
        int[] frequencyS = new int[26];
        for (int i = 0; i < pLen; i++) {
            char ch = p.charAt(i);
            frequencyP[ch - 'a']++;
        }

        // s: "cbaebabacd" p: "abc"
        for (int i = 0; i < sLen; i++) {
            // 从pLen下标开始，减小滑动窗口
            if (i >= pLen) {
                frequencyS[s.charAt(i - pLen) - 'a']--;
            }
            frequencyS[s.charAt(i) - 'a']++;
            if (Arrays.equals(frequencyP, frequencyS)) {
                res.add(i - pLen + 1);
            }
        }

        return res;
    }
}
