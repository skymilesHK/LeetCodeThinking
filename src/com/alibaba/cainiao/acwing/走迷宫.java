package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 走迷宫 {

    static final Scanner in = new Scanner(System.in);
    static int n, m, res;
    static int[][] g, d;    // g是输入的迷宫，d是任意点到原点的距离（但是d还有一个功能类似visit数组，-1表示点访问过）
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    // https://www.acwing.com/activity/content/problem/content/907/1/
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
        // 表示[i,j]到原点距离，-1表示没有visit过
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], -1);
        }
        d[0][0] = 0;
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Pair t = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int x = t.first + dx[dir];
                    int y = t.second + dy[dir];
                    if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1) {
                        // bfs中的一个点，只有在第一次被搜索到，才能算最短路径的点
                        d[x][y] = d[t.first][t.second] + 1;
                        q.offer(new Pair(x, y));
                    }
                }
            }
        }

        return d[n - 1][m - 1];
    }
}

class Pair implements Comparable<Pair> {
    public Integer first;
    public Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return this.first.compareTo(o.first);
    }
}
