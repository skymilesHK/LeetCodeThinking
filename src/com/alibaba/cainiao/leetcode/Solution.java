package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {
    // https://www.acwing.com/video/2967/   建图参考
    List<Integer> res = new ArrayList<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildGraph(root);
        bfs(target, K);
        return res;
    }

    private void bfs(TreeNode target, int k) {
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(target.val);
        int dist = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Integer t = q.poll();
                if (dist == k) {
                    res.add(t);
                }

                if (graph.containsKey(t)) {
                    for (Integer next : graph.get(t)) {
                        if (visited.contains(next)) {
                            continue;
                        }

                        visited.add(next);
                        q.offer(next);
                    }
                }
            }

            dist++;
        }

    }

    // 树建无向图的标准方法
    private void buildGraph(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            graph.computeIfAbsent(root.val, p -> new HashSet<>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, p -> new HashSet<>()).add(root.val);
            buildGraph(root.left);
        }

        if (root.right != null) {
            graph.computeIfAbsent(root.val, p -> new HashSet<>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, p -> new HashSet<>()).add(root.val);
            buildGraph(root.right);
        }
    }
}
