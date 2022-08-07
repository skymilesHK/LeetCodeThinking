package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 树的重心 {

    static int N = 100009, M = 2 * 100009, n = 0, res = N, idx = 0;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] next = new int[M];
    static boolean[] st = new boolean[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        Arrays.fill(h, -1);

        // n个点,n-1条边
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }

        int rootSize = dfs(1);
        System.out.println(res);
    }

    // 以u为root的树子树中的数量
    private static int dfs(int u) {
        st[u] = true;
        // ans是局部最小, res是全局最小
        int sum = 1, ans = 1;
        for (int i = h[u]; i != -1; i = next[i]) {
            // 周边的j点
            int j = e[i];
            if (!st[j]) {
                int sub = dfs(j);
                sum += sub;
                ans = Math.max(ans, sub);
            }
        }

        ans = Math.max(ans, n - sum);
        res = Math.min(res, ans);
        return sum;
    }

    // 点a->点b的边
    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
