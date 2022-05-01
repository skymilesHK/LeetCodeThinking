package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 排书 {

    static int n = 0;
    // 书的编号, 恢复现场使用
    static int[] p;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            n = in.nextInt();
            p = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }

            int depth = 0;
            while (depth < 5 && !dfs(0, depth)) {
                depth++;
            }

            if (depth == 5) {
                System.out.println("5 or more");
            } else {
                System.out.println(depth);
            }
        }
    }

    /**
     * @param u     当前迭代深度
     * @param depth 迭代加深最大深度
     * @return
     */
    private static boolean dfs(int u, int depth) {
        if (u + f() > depth) {
            return false;
        }

        // 已经满足要求
        if (f() == 0) {
            return true;
        }

        // 并没有初始化也可以使用
        int[] bk;
        // 先遍历长度
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                for (int k = r + 1; k < n; k++) {
                    bk = p.clone();
                    int y = l;
                    for (int x = r + 1; x <= k; x++, y++) {
                        p[y] = bk[x];
                    }
                    for (int x = l; x <= r; x++, y++) {
                        p[y] = bk[x];
                    }
                    if (dfs(u + 1, depth)) {
                        return true;
                    }
                    p = bk.clone();
                }
            }
        }

        return false;
    }

    private static int f() {
        // tot是不满足要求的pair个数
        int tot = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (p[i + 1] != p[i] + 1) {
                tot++;
            }
        }

        // tot除以3向上取整=tot+2除以3向下取整
        return (tot + 2) / 3;
    }

}
