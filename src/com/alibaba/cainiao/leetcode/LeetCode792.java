package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 792. 匹配子序列的单词数
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 *
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 * 注意:
 *
 * 所有在words和 S 里的单词都只由小写字母组成。
 * S 的长度在 [1, 50000]。
 * words 的长度在 [1, 5000]。
 * words[i]的长度在[1, 50]。
 */
public class LeetCode792 {
    // S = "abcde"
    // words = ["a", "bb", "acd", "ace"]
    public int numMatchingSubseq(String t, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isSubsequence(word, t)) {
                res++;
            }
        }
        return res;
    }

    private boolean isSubsequence(String s, String t) {
        int idxT = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            idxT = t.indexOf(ch, idxT);
            if (idxT < 0) {
                return false;
            }
            idxT++;
        }
        return true;
    }
}
