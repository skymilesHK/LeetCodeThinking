package com.alibaba.cainiao.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class LeetCode131 {

    // https://leetcode-cn.com/problems/palindrome-partitioning/solution/131-fen-ge-hui-wen-chuan-hui-su-sou-suo-suan-fa-xi/
    List<List<String>> res = new LinkedList<>();
    int n = 0;

    public List<List<String>> partition(String s) {
        n = s.length();
        dfs(s, 0, new LinkedList<String>());
        return res;
    }

    /**
     *
     * @param s     字符串
     * @param start 每层dfs从start位置开始枚举切割位置
     * @param path  中间结果
     */
    private void dfs(String s, int start, LinkedList<String> path) {
        // 表示切分s到头了,可以返回结果集
        if (start == s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }

        // 每层从start枚举每个切分终点的位置
        for (int i = start; i < n; i++) {
            // 前半部分是回文
            if (isPalindrome(s, start, i)) {
                // 前半部分试着加入结果集, 缩小范围继续dfs
                path.add(s.substring(start, i + 1));
                dfs(s, i + 1, path);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        for (; i < j; i++, j--) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 != ch2) {
                return false;
            }
        }
        return true;
    }
}
