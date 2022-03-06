package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 数字转换 {

    // https://www.acwing.com/activity/content/code/content/1147479/

    static int N = 50001, M = N + N;
    static int n, idx, res;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] next = new int[M];
    static int[] w = new int[M];
    static boolean[] st = new boolean[N];
    static int[] sum = new int[N]; // 每个数的约数之和
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n / i; j++) {  // 约数之和不包括自身，所以 j 从 2 开始
                sum[i * j] += i;
            }
        }

        Arrays.fill(h, -1);
        // 1 的约数之和是 0，不符合在不超过 n 的正整数范围内进行变化的要求，所以 i 从 2 开始
        for (int i = 2; i <= n; i++) {
            if (sum[i] < i) {
                // 为什么不是建双向边?因为没必要，以1为根的话只会往下搜索，不会再往上了
                add(sum[i], i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                int du = dfs(i);
            }
        }
        System.out.println(res);
    }

    private static int dfs(int u) {
        int d1 = 0, d2 = 0;
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            int du = dfs(j) + 1;
            if (du >= d1) {
                d2 = d1;
                d1 = du;
            } else if (du > d2) {
                d2 = du;
            }
        }
        res = Math.max(res, d1 + d2);
        return d1;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }

}
