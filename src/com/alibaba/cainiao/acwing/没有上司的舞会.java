package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 没有上司的舞会 {

    // https://www.acwing.com/problem/content/287/

    static int N = 6009;
    static int n = 0;
    static int idx = 0;
    static int[] happy = new int[N];
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] next = new int[N];
    static int[][] dp = new int[N][2];
    static boolean[] hasParent = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            happy[i] = in.nextInt();
        }

        Arrays.fill(h, -1);

        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(b, a);
            hasParent[a] = true;
        }

        int root = 1;
        while (hasParent[root]) {
            root++;
        }

        dfs(root);

        System.out.println(Math.max(dp[root][0], dp[root][1]));
    }

    static void dfs(int u) {
        dp[u][1] = happy[u];
        // u的所有下属
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            dfs(j);

            dp[u][0] += Math.max(dp[j][0], dp[j][1]);
            dp[u][1] += dp[j][0];
        }
    }

    // b是a的父节点
    static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
