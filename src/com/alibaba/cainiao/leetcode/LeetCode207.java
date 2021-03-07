package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 *
 * 提示：
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 */
public class LeetCode207 {

    int N = 100001, n = 0;
    int[] h = new int[N];
    int[] next = new int[N];
    int[] e = new int[N];
    int idx = 0, resIdx = 0;
    int[] d = new int[N];
    int[] res = null;
    Queue<Integer> q = new ArrayDeque<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        res = new int[n];
        Arrays.fill(h, -1);

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];
            // 添加一条边a->b
            add(a, b);
            // b点的入度+1
            d[b]++;
        }

        return topologicalSort();
    }

    private boolean topologicalSort() {
        // 这里v是节点的值,入度为0的加入队列
        for (int v = 0; v < n; v++) {
            if (d[v] == 0) {
                q.offer(v);
            }
        }

        while (!q.isEmpty()) {
            // t节点
            Integer t = q.poll();
            res[resIdx++] = t;
            //遍历头节点的每一个出边,这里i表示出边节点编号
            for (int i = h[t]; i != -1; i = next[i]) {
                // 出边的点j
                int j = e[i];
                if (--d[j] == 0) {
                    q.offer(j);
                }
            }

        }

        return resIdx == n;
    }

    private void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx;
        idx++;
    }

}
