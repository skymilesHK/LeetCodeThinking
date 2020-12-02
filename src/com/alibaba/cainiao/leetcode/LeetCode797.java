package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 */
public class LeetCode797 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(graph, 0, path);
        return res;
    }

    private void dfs(int[][] graph, int start, LinkedList<Integer> path) {
        if (start == graph.length - 1) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int node : graph[start]) {
            path.add(node);
            dfs(graph, node, path);
            path.removeLast();
        }
    }
}
