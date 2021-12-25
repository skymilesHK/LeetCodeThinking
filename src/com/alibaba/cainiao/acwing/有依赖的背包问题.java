package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 有依赖的背包问题 {

    // https://www.acwing.com/problem/content/description/10/
    static int N, V;
    static int[] h, e, next = new int[101];
    static int idx;
    static int[][]dp = new int[101][101];   // 所有必选i节点及其子树，总体积在j的条件下的方案，取最大值
    static int[] v = new int[101];
    static int[] w = new int[101];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        N = in.nextInt();
        V = in.nextInt();

        Arrays.fill(h, -1);
        int root = 0;
        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            int p = in.nextInt();
            if (p == -1) {
                root = i;
            } else {
                add(p, i);
            }
        }

        dfs(root);
        System.out.println(dp[root][V]);
    }

    private static void dfs(int u) {
        for (int i = h[u]; i != -1; i = next[i]) {
            int son = e[i];
            dfs(son);

            // 分组背包
            // 必选u点，所以预留体积
            for (int j = V - v[u]; j >= 0; j--) {
                // 循环决策,因为按照体积种类进行划分，有j+1种, k本身就是体积，；类似v[k]
                for (int k = 0; k <= j; k++) {
                    dp[u][j] = Math.max(dp[u][j], dp[u][j - k] + dp[son][k]);
                }
            }
        }

        // 加上刚刚默认选择的父节点u的价值
        for (int i = V; i - v[u] >= 0; i--) {
            dp[u][i] = dp[u][i - v[u]] + w[u];
        }

        //因为我们是从叶子结点开始往上做，所以如果背包容积不如当前物品的体积大，那就不能选择当前结点及其子节点，因此赋值为零
        for (int i = 0; i < v[u]; i++) {
            dp[u][i] = 0;
        }
    }

    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
