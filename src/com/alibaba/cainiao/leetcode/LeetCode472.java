package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 472. Concatenated Words
 * Hard
 *
 *
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 *
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 *
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 *  "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Note:
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 */
public class LeetCode472 {

    List<String> res = new ArrayList<>();
    Set<String> dict = new HashSet<>();
    Set<String> memo = new HashSet<>();
    int n = 0;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        n = words.length;
        if (n == 0) {
            return res;
        }

        for (int i = 0; i < n; i++) {
            dict.add(words[i]);
        }

        for (String word : words) {
            dict.remove(word);
            boolean b = wordBreak(word);
            dict.add(word);
        }

        for (String m : memo) {
            if (dict.contains(m)) {
                res.add(m);
            }
        }

        return res;
    }

    private boolean wordBreak(String s) {
        if (dict.contains(s)) {
            return true;
        }
        if (memo.contains(s)) {
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (dict.contains(left) && wordBreak(right)) {
                memo.add(s);
                return true;
            }
        }

        return false;
    }

}
