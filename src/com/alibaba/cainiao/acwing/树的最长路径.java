package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 树的最长路径 {
    // https://www.acwing.com/video/412/

    static int N = 10001, M = N + N;
    static int n, idx, res;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] next = new int[M];
    static int[] w = new int[M];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        Arrays.fill(h, -1);
        // n-1条边
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a, b, c);
            add(b, a, c);
        }

        // 任选一个点当树的最高点
        int dist = dfs(1, -1);
        System.out.println(res);
    }

    // 返回值是u开始向树下的走的最大长度, u必须是最高点
    private static int dfs(int u, int parent) {
        // u开始向树下的走的最大长度
        int dist = 0;
        // 经过u的最大长度和第二大长度
        int d1 = 0, d2 = 0;
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            if (j == parent) {
                continue;
            }
            int d = dfs(j, u) + w[i];
            dist = Math.max(dist, d);

            if (d >= d1) {
                d2 = d1;
                d1 = d;
            } else if (d >= d2) {
                d2 = d;
            }
        }

        res = Math.max(res, d1 + d2);
        return dist;
    }

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
