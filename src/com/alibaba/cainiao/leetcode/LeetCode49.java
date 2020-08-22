package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 49. Group Anagrams
 * Medium
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class LeetCode49 {

    Map<String, List<String>> map = new HashMap<>();

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return res;
        }

        for (int i = 0; i < strs.length; i++) {
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String sortedStr = new String(chArr);
            List<String> list = null;
            if (map.containsKey(sortedStr)) {
                list = map.get(sortedStr);
            } else {
                list = new ArrayList<>();
            }
            list.add(strs[i]);
            map.put(sortedStr, list);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }

        return res;
    }

}
