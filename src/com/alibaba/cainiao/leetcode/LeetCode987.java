package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * Vertical Order Traversal of a Binary Tree
 * https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class LeetCode987 {

    List<List<Integer>> res = new ArrayList<>();
    Queue<Pair<Integer, TreeNode>> q = new ArrayDeque<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        int minDist = 0, maxDist = 0;
        q.offer(new Pair<>(0, root));
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Pair<Integer, TreeNode> t = q.poll();
                Integer dist = t.first;
                TreeNode node = t.second;
                map.computeIfAbsent(dist, p -> new ArrayList<>());
                List<Integer> list = map.get(dist);
                if (!list.isEmpty()) {
                    Integer pre = list.get(list.size() - 1);
                    if (pre > node.val) {
                        list.remove(list.size() - 1);
                        list.add(node.val);
                        list.add(pre);
                    }
                } else {
                    list.add(node.val);
                    map.put(dist, list);
                }

                minDist = Math.min(minDist, dist);
                maxDist = Math.max(maxDist, dist);
                if (node.left != null) {
                    q.offer(new Pair<>(dist - 1, node.left));
                }
                if (node.right != null) {
                    q.offer(new Pair<>(dist + 1, node.right));
                }
            }

        }

        while (minDist <= maxDist) {
            if (map.containsKey(minDist)) {
                List<Integer> list = map.get(minDist);
                res.add(list);
            }
            minDist++;
        }

        return res;
    }

    private class Pair<K extends Number, V> implements Comparable<K> {
        private K first;
        private V second;

        public Pair() {
        }

        public Pair(K f, V s) {
            this.first = f;
            this.second = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Pair<K, V> pair = (Pair<K, V>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public int compareTo(K k) {
            Integer f = (Integer) this.first;
            Integer o = (Integer) k;
            return f - o;
        }
    }
}


