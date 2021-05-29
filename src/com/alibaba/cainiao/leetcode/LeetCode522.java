package com.alibaba.cainiao.leetcode;

import java.util.Map;

/**
 * 522. 最长特殊序列 II
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 *
 *
 *
 * 示例：
 *
 * 输入: "aba", "cdc", "eae"
 * 输出: 3
 *
 *
 * 提示：
 *
 * 所有给定的字符串长度不会超过 10 。
 * 给定字符串列表的长度将在 [2, 50 ] 之间。
 */
public class LeetCode522 {

    // https://www.acwing.com/video/1946/
    public int findLUSlength(String[] strs) {
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            boolean isSub = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSequence(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }

            // 如果还是isSub==false
            if (!isSub) {
                res = Math.max(res, strs[i].length());
            }

        }

        return res;
    }

    private boolean isSequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int i = 0, j = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == sLen;
    }
}
