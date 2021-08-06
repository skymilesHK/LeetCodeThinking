package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static final Scanner in = new Scanner(System.in);
    static int n, m, res;
    static int[][] g, d;    // g是输入的迷宫，d是任意点到原点的距离（但是d还有一个功能类似visit数组，-1表示点访问过）
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        g = new int[n][m];
        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = in.nextInt();
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair<>(0, 0));

        // 表示[i,j]到原点距离，-1表示没有visit过
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    d[0][0] = 0;
                } else {
                    d[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Pair<Integer, Integer> t = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = t.first + dx[j];
                    int y = t.second + dy[j];
                    if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1) {
                        // bfs中的一个点，只有在第一次被搜索到，才能算最短路径的点
                        // 更新d数组
                        d[x][y] = d[t.first][t.second] + 1;
                        //加入队列
                        q.offer(new Pair<>(x, y));
                    }
                }
            }
        }

        return d[n - 1][m - 1];
    }

    static class Pair<K extends Number, V extends Number> implements Comparable<K> {

        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(K k) {
            Integer t = (Integer) this.first;
            Integer o = (Integer) k;
            return t - o;
        }
    }
}