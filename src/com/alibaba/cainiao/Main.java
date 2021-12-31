package com.alibaba.cainiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // https://www.acwing.com/video/222/    看评论Volantical. 的
    // https://www.acwing.com/solution/content/5014/
    static int N, V;
    static int[] h = new int[101];
    static int[]e = new int[101];
    static int[] next = new int[101];
    static int idx;
    static int[][] dp = new int[101][101];   // 必选i节点及其子树，总体积在j的条件下的方案数
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
        // 对当前组(子树)进行遍历,u点必须选
        for (int i = u; i != -1; i = next[i]) {
            int son = e[i];
            dfs(son);

            // 分组背包,循环体积
            // 必选u点，所以预留体积(这个已经压缩过一维度了)
            for (int j = V - v[u]; j >= 0; j--) {
                // 循环决策,因为按照体积种类进行划分，有son+1种, k本身就是体积，；类似v[k]
                for (int k = 0; k <= j; k++) {
                    dp[u][j] = Math.max(dp[u][j], dp[u][j - k] + dp[son][k]);
                }
            }
        }

        // 将物品u加进去
        // 加上刚刚默认选择的父节点u的价值
        for (int j = V; j >= v[u]; j--) {
            dp[u][j] = dp[u][j - v[u]] + w[u];
        }
        // 因为我们是从叶子结点开始往上做，所以如果背包容积不如当前物品的体积大，那就不能选择当前结点及其子节点，因此赋值为零
        for (int j = 0; j < v[u]; j++) {
            dp[u][j] = 0;
        }
    }

    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}