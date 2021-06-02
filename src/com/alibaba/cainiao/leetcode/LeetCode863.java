package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 *
 * 提示：
 *
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 */
public class LeetCode863 {
    // https://www.acwing.com/video/2967/   建图参考
    List<Integer> res = new ArrayList<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildGraph(root);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(target.val);
        int dist = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Integer t = q.poll();
                if (dist == K) {
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

        return res;
    }

    // 树建无向图的标准方法
    private void buildGraph(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            graph.computeIfAbsent(root.val, x -> new HashSet<>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, x -> new HashSet<>()).add(root.val);
            buildGraph(root.left);
        }

        if (root.right != null) {
            graph.computeIfAbsent(root.val, x -> new HashSet<>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, x -> new HashSet<>()).add(root.val);
            buildGraph(root.right);
        }
    }
}
