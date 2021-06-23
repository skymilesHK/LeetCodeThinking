package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break II
 * 题目描述
 * 给定一个非空字符串 s 和一个非空词典 wordDict，找到 s 被分割成一个或多个单词分隔序列的所有方案。
 *
 * 样例
 * 输入：
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出：
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 输入：
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出：
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 输入：
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出：
 * []
 *
 *
 * 作者：wzc1995
 * 链接：https://www.acwing.com/solution/content/239/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
// https://www.youtube.com/watch?v=JqOIRBC0_9c

public class LeetCode140 {
    // 用于存储结果的List
    private List<String> res = new ArrayList<>();
    private Set<String> dic = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dic.addAll(wordDict);
        dfs(s,  new ArrayList<>());
        return res;
    }

    private void dfs(String s, List<String> path) {
        if (0 >= s.length()) {
            res.add(String.join(" ", path));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if (!dic.contains(left)) {
                continue;
            }
            path.add(left);
            String right = s.substring(i);
            dfs(right, path);
            path.remove(path.size() - 1);
        }
    }
}