package com.alibaba.cainiao;

import java.util.Scanner;

public class Main {

    // https://www.acwing.com/problem/content/839/
    static int N = 100009;
    static int n, m = 0;
    static int[] parent = new int[N];
    static int[] size = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        do {
            String s = in.next();
            if ("C".equals(s)) {
                int a = in.nextInt();
                int b = in.nextInt();
                union(a, b);
            } else if ("Q1".equals(s)) {
                int a = in.nextInt();
                int b = in.nextInt();
                if (isConnected(a, b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                int a = in.nextInt();
                int sz = size[find(a)];
                System.out.println(sz);
            }
        } while (--m > 0);
    }

    static int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    static void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

    static boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
