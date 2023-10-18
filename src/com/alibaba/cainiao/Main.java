package com.alibaba.cainiao;

import java.util.*;

public class Main {

    // https://www.acwing.com/solution/content/52967/
    static int N = 5, M = 1002;
    static int n = 4, m = 0;
    static int[] v = {0, 10, 20, 50, 100};
    static int[][] dp = new int[N][M];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // m元钱全部用来买书，书的价格为10元，20元，50元，100元
        m = in.nextInt();

        //dp
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) {
                    dp[i][j] += dp[i][j - v[i]];
                }
            }
        }

        System.out.println(dp[n][m]);
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


