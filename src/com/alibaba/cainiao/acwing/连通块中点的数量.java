package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 连通块中点的数量 {

    // UF
    static int N = 100009;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        UF uf = new UF(n + 1);

        do {
            String s = in.next();
            if ("C".equals(s)) {
                int a = in.nextInt();
                int b = in.nextInt();
                uf.union(a, b);
            } else if ("Q1".equals(s)) {
                int a = in.nextInt();
                int b = in.nextInt();
                if (uf.isConnected(a, b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                int a = in.nextInt();
                int aRoot = uf.find(a);
                System.out.println(uf.getSize(aRoot));
            }
        } while (--m > 0);
    }

    static class UF {
        int[] parent;
        int[] h;
        int[] size;

        public UF(int sz) {
            parent = new int[sz];
            h = new int[sz];
            size = new int[sz];

            for (int i = 0; i < sz; i++) {
                parent[i] = i;
                h[i] = 1;
                size[i] = 1;
            }
        }

        public int getSize(int index) {
            return size[index];
        }

        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public boolean union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return false;
            }

            if (h[pRoot] < h[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else if (h[pRoot] > h[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                h[qRoot]++;
                size[qRoot] += size[pRoot];
            }
            return true;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
