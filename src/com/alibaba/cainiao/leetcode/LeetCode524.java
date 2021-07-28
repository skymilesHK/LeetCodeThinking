package com.alibaba.cainiao.leetcode;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 */
public class LeetCode524 {

    // https://www.bilibili.com/video/BV1i7411E7t6?from=search&seid=3056083929423282239 思路

    public String findLongestWord(String t, List<String> dic) {
        if (t == null || t.length() == 0 || dic == null || dic.size() == 0) {
            return "";
        }

        String res = "";
        for (String s : dic) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (s.charAt(j) == t.charAt(i)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }

            // 找到一个结果
            if (j == s.length()) {
                if ("".equals(res) || res.length() < s.length() || (res.length() == s.length() && res.compareTo(s) > 0)) {
                    res = s;
                }
            }
        }

        return res;
    }
}
