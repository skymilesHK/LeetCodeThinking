package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 合并集合 {

    static int N = 100001, n = 0, m = 0;
    static int[] parent = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            parent[i] = in.nextInt();
        }

        do {
            String str = in.next();
            int a = in.nextInt();
            int b = in.nextInt();
            if ("M".equals(str)) {
                // 合并集合
                int aRoot = find(a);
                int bRoot = find(b);
                parent[aRoot] = bRoot;
            } else {
                // 是否同个集合
                if (find(a) == find(b)) {
                    System.out.println("Yes"); //如果两个集合的祖先相同说明两个集合在同个集合中。
                } else {
                    System.out.println("No"); //否则相反
                }
            }
        } while (--m > 0);
    }

    private static int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return parent[p];
        // if(parent[p] != p)
        //    parent[p] = find(parent[p]);
        // return parent[p];
    }
}
