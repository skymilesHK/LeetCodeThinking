package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 227. 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class LeetCode227 {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String w : words) {
            if (judge(S, w)) {
                res++;
            }
        }
        return res;
    }

    // S = "heeellooo"
    // words = ["hello", "hi", "helo"]
    private boolean judge(String s, String w) {
        int sLen = s.length(), wLen = w.length(), i = 0, j = 0;
        while (i < sLen) {
            if (j < wLen && s.charAt(i) == w.charAt(j)) {
                j++;
            } else if (i >= 2 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                continue;
            } else if(i + 1 < sLen && i > 0 && s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            } else {
                return false;
            }
            i++;
        }
        return j == wLen;
    }
}
