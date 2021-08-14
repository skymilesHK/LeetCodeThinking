package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 */
public class 剑指Offer38 {
    List<String> res = new ArrayList<>();
    boolean[] visited = null;
    public String[] permutation(String s) {
        visited = new boolean[26];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars, 0, "");
        String[] arr = new String[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(char[] chars, int u, String path) {
        if (u == chars.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            //前一个没有访问过
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                dfs(chars, u + 1, path + chars[i]);
                visited[i] = false;
            }
        }
    }
}
