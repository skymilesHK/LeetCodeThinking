package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 336. Palindrome Pairs
 * https://leetcode-cn.com/problems/palindrome-pairs/
 */
public class LeetCode336 {

    // https://www.acwing.com/solution/content/363/
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int n = words.length;
        if (n == 0 || n == 1) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            map.put(sb.reverse().toString(), i);
        }

        // special cases: "" can be combine with any palindrome string
        if (map.containsKey("")) {
            for (int i = 0; i < n; i++) {
                String w = words[i];
                if (!"".equals(w) && isPalindrome(w)) {
                    res.add(Arrays.asList(map.get(""), i));
                }
            }
        }

        // 输入：["abcd","dcba","lls","s","sssll"]
        // 输出：[[0,1],[1,0],[3,2],[2,4]]
        // 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
        // 枚举每个字符串，切分字符串
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            // 找每个单词的分割点
            for (int j = 0; j < w.length(); j++) {
                String left = w.substring(0, j);
                String right = w.substring(j);
                // Case 2: sla ls(reverse:sl)
                if (map.containsKey(left) && isPalindrome(right) && map.get(left) != i) {
                    res.add(Arrays.asList(i, map.get(left)));
                }

                // Case 3: lslab ba(reverse:ba)
                if (map.containsKey(right) && isPalindrome(left) && map.get(right) != i) {
                    res.add(Arrays.asList(map.get(right), i));
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
