package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 684. Redundant Connection
 * Medium
 *
 * 1692
 *
 * 233
 *
 * Add to List
 *
 * Share
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 *
 * Update (2017-09-26):
 * We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
 */
public class LeetCode684 {

    // https://www.youtube.com/watch?v=4hJ721ce010
    // 第一种DFS，复杂度O(n^2)
    public int[] findRedundantConnection(int[][] edges) {
        // build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            Set<Integer> visited = new HashSet<>();
            visited.add(edge[0]);
            if (dfs(graph, visited, edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }

            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashSet<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new HashSet<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return new int[]{-1, -1};
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int start, int end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) return false;
        if (start == end) return true;

        for (int i : graph.get(start)) {
            if (visited.contains(i)) continue;
            visited.add(i);
            if (dfs(graph, visited, i, end)) {
                return true;
            }
            ;
        }
        return false;

    }

}
