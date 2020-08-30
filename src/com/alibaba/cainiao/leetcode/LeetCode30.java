package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * Hard
 *
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 *
 *
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input:
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * Output: []
 */
public class LeetCode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int wordCnt = words.length;
        if (sLen == 0 || wordCnt == 0) {
            return res;
        }

        int oneWordLen = words[0].length();
        int allWordLen = oneWordLen * wordCnt;
        Map<String/**word**/, Integer/**cnt**/> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < sLen - allWordLen + 1; i++) {
            String window = s.substring(i, i + allWordLen);

            Map<String, Integer> subMap = new HashMap<>();
            for (int j = 0; j < allWordLen; j += oneWordLen) {
                String substring = window.substring(j, j + oneWordLen);
                subMap.put(substring, subMap.getOrDefault(substring, 0) + 1);
            }
            if (map.equals(subMap)) {   //http://c.biancheng.net/view/4747.html
                res.add(i);
            }
        }
        return res;
    }

}
