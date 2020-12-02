package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 886. Possible Bipartition
 * Medium
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class LeetCode886 {

    ArrayList<Integer>[] graph;
    // 定义 colors 数组，初始值为 0 表示未被访问，赋值为 1 或者 2 表示两种不同的颜色。
    int[] colors = null;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];
        colors = new int[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            int a = d[0];
            int b = d[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 dfs 染色。
        for (int i = 1; i < graph.length; i++) {
            if (colors[i] == 0) {
                if (!dfs(graph, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<Integer>[] graph, int u, int newColor) {
        colors[u] = newColor;

        for (Integer v : graph[u]) {
            if (colors[v] == 0) {
                if (!dfs(graph, v, 3 - newColor)) {
                    return false;
                }
            } else if (colors[v] == newColor) {
                // 如果要对某顶点染色时，发现它已经被染色了，则判断它的颜色是否与本次要染的颜色相同，如果矛盾，说明此无向图无法被正确染色，返回 false。
                return false;
            } else {
                continue;
            }
        }

        return true;
    }

}
