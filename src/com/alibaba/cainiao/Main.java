package com.alibaba.cainiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // https://www.acwing.com/solution/content/7920/
    static int N = 6001, n = 0, idx = 0;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] next = new int[N];
    static int[][] dp = new int[N][2];
    static int[] happy = new int[N];
    static boolean[] hasParent = new boolean[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        // 输入快乐度
        for (int i = 1; i <= n; i++) {
            happy[i] = in.nextInt();
        }

        Arrays.fill(h, -1);
        // n个点n-1条边
        for (int i = 0; i < n - 1; i++) {
            // K 是 L 的直接上司
            int l = in.nextInt();
            int k = in.nextInt();
            add(k, l);
            hasParent[l] = true;
        }

        // 找父节点
        int root = 1;
        while (hasParent[root]) {
            root++;
        }
        dfs(root);
        System.out.println(Math.max(dp[root][0], dp[root][1]));
    }

    // 寻找以u为root的树中，寻找快乐指数总和
    private static void dfs(int u) {
        dp[u][0] = 0;
        dp[u][1] = happy[u];
        // u的所有下属
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            dfs(j);
            // 当前u结点不选，子结点可选可不选
            dp[u][0] += Math.max(dp[j][0], dp[j][1]);
            // 当前u结点选，子结点一定不能选
            dp[u][1] += dp[j][0];
        }
    }

    // a->b连一条边
    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}

class UF {
    int[] parent;
    int[] h;

    public UF(int size) {
        parent = new int[size];
        h = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            h[i] = 1;
        }
    }

    public int getSize() {
        return parent.length;
    }

    public boolean union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return false;
        }

        if (h[pRoot] < h[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (h[pRoot] > h[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            h[qRoot]++;
        }
        return true;
    }

    public int find(int p) {
        if (p < 0 || p >= getSize()) {
            throw new IllegalArgumentException("p is out of bound");
        }

        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


