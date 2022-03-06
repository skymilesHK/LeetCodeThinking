package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 树的中心 {
    // https://www.acwing.com/solution/content/15929/   path的含义
    // https://www.acwing.com/solution/content/13025/   代码
    static int N = 10001, M = N + N;
    static int n, idx, res = 0x3f3f3f3f;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] next = new int[M];
    static int[] w = new int[M];
    static int[] d1 = new int[N];   // 向下走的最大距离
    static int[] d2 = new int[N];   // 向下走的次大距离
    static int[] up = new int[N];   // 向上走的最大距离
    static int[] path = new int[N]; // 最大距离从哪个点上来的
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a, b, c;
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            add(a, b, c);
            add(b, a, c);
        }

        int du = dfs_d(1, -1);
        dfs_u(1, -1);

        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(d1[i], up[i]));
        }

        System.out.println(res);
    }

    /**
     * 向上找最大和次大距离
     *
     * @param u      都是点，不是点j的下标
     * @param father 都是点，不是点j的下标
     * @return
     */
    private static void dfs_u(int u, int father) {
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            if (j == father) {
                continue;
            }

            if (j == path[u]) {
                up[j] = Math.max(up[u], d2[u]) + w[i];
            } else {
                up[j] = Math.max(up[u], d1[u]) + w[i];
            }
            dfs_u(j, u);
        }
    }

    /**
     * 向下找最大和次大距离
     *
     * @param u      都是点，不是点j的下标
     * @param father 都是点，不是点j的下标
     * @return
     */
    private static int dfs_d(int u, int father) {
        // 经过u的最大长度和第二大长度
        d1[u] = d2[u] = -0x3f3f3f3f;
        for (int i = h[u]; i != -1; i = next[i]) {
            // 点j，不是点j的下标
            int j = e[i];
            if (j == father) {
                continue;
            }

            int du = dfs_d(j, u) + w[i];
            if (du > d1[u]) {
                d2[u] = d1[u];
                d1[u] = du;
                path[u] = j;    //表示以u为根节点，向下走的来源节点值是j
            } else if (du > d2[u]) {
                d2[u] = du;
            }
        }

        //如果没有被更新说明是叶节点，那么最大值和次大值都是0
        if (d1[u] <= -0x3f3f3f3f) {
            d1[u] = d2[u] = 0;
        }
        return d1[u];//每次返回这个最大值
    }

    private static void add(int a, int b, int c) {
        w[idx] = c;
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
