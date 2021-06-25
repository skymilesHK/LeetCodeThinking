package com.alibaba.cainiao.leetcode;

import java.util.*;

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
        Collections.addAll(dict, words);
        for (String word : words) {
            dict.remove(word);
            if (dfs(word)) {
                res.add(word);
            }
            dict.remove(word);
        }

        return res;
    }

    // 类似work break
    private boolean dfs(String word) {
        if (memo.contains(word) || dict.contains(word)) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (dict.contains(left) && dfs(right)) {
                memo.add(word);
                return true;
            }
        }
        memo.remove(word);
        return false;
    }
}
