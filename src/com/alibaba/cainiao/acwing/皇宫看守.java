package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 皇宫看守 {
    // https://www.acwing.com/solution/content/33857/ 代码
    // https://www.acwing.com/solution/content/13979/ 定义
    static final int N = 1509;
    static int n;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] w = new int[N];
    static int[] next = new int[N];
    static int idx;
    static int[][] dp = new int[N][3];
    static boolean[] st = new boolean[N]; // 标记非根节点

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        Arrays.fill(h, -1);
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), c = in.nextInt(), cnt = in.nextInt();
            w[a] = c; // 权值在节点上
            while (cnt-- > 0) {
                int b = in.nextInt();
                add(a, b);
                st[b] = true;
            }
        }

        int root = 1;
        while (st[root]) {
            root++;
        }
        dfs(root);

        System.out.println(Math.min(dp[root][1], dp[root][2]));
    }

    static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u) {
        dp[u][2] = w[u];

        int sum = 0; // ∑min(f(j, 1), f(j, 2))
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            dfs(j);
            dp[u][0] += Math.min(dp[j][1], dp[j][2]);
            dp[u][2] += Math.min(Math.min(dp[j][0], dp[j][1]), dp[j][2]);
            sum += Math.min(dp[j][1], dp[j][2]);
        }

        dp[u][1] = 0x3f3f3f3f;
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            dp[u][1] = Math.min(dp[u][1], dp[j][2] + sum - Math.min(dp[j][1], dp[j][2]));
        }
    }

}
