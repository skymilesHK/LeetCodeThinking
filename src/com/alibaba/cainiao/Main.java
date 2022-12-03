package com.alibaba.cainiao;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    // https://www.bilibili.com/video/av34962180?p=2     思路
    // https://leetcode.com/problems/pyramid-transition-matrix/discuss/374538/Java-2ms-Easy-DFS      代码

    HashSet<Character>[][] allows = new HashSet[7][7];

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (allowed.size() < 1) {
            return false;
        }

        allowed.forEach(str -> {
            int a = str.charAt(0) - 'A';
            int b = str.charAt(1) - 'A';
            char c = str.charAt(2);
            if (allows[a][b] == null) {
                allows[a][b] = new HashSet<>();
            }
            allows[a][b].add(c);
        });

        return dfs(bottom, "");
    }

    /**
     * 能否从上一层bottom是否能枚举出当前层的结果
     *
     * @param last 上一层
     * @param now  当前层
     * @return
     */
    private boolean dfs(String last, String now) {
        if (last.length() == 1) {
            return true;
        }

        // 说明当前这层枚举完毕。递归做更上一层的dfs任务
        if (now.length() + 1 == last.length()) {
            return dfs(now, "");
        }

        // 枚举allows
        // Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
        // candidate = G, E, A, F
        int a = last.charAt(now.length()) - 'A';
        int b = last.charAt(now.length() + 1) - 'A';
        if (null == allows[a][b]) {
            return false;
        }

        for (char candidate : allows[a][b]) {
            if (dfs(last, now + candidate)) {
                return true;
            }
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


