package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("BCG", "CDE", "GEA", "FFF");
    }

    // https://www.acwing.com/video/21/   先看这个基础bfs
    // https://www.acwing.com/video/453/ 然后看这个多源点（或超级源点）最短路径问题，注意不等于多源最短路问题
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int m = 0, n = 0;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return matrix;
        }

        m = matrix.length;
        n = matrix[0].length;
        int[][] dis = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>(m);
        // 初始时将所有 0 元素的坐标进队(反过来寻找)
        // 答案数组 dis，0 元素位置的值为 0，其余为 -1(标记的初始值，表示没有更新过距离)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[] {i, j});
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                int[] t = q.poll();
                // 对这个队列开始进行宽度优先搜索，每次扩展上下左右四个方向，
                // 若发现新的位置在 dis 中值为 -1，则更新新位置的答案为当前位置答案加 1
                for (int j = 0; j < 4; j++) {
                    int x = t[0] + dx[j];
                    int y = t[1] + dy[j];
                    // bfs中的一个点，只有在第一次被搜索到，才能算最短路径的点
                    if (x >= 0 && x < m && y >= 0 && y < n && dis[x][y] == -1) {
                        // 更新新位置的答案
                        dis[x][y] = dis[t[0]][t[1]] + 1;
                        // 队列加入+1距离的节点
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }

        return dis;
    }
}
