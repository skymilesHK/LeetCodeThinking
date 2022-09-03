package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 染色法判定二分图 {

    static int N = 100001;
    static int M = 200002;
    static int n, m = 0;
    static int idx = 0;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] next = new int[M];
    static int[] color = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);

        do {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        } while (--m > 0);

        // 标记是否染色成功
        boolean flag = true;
        // 枚举每个点
        for (int i = 1; i <= n; i++) {
            // 若未染色,染色可以使用1和2区分不同颜色，用0表示未染色
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // dfs(u,c)表示把u号点染色成c颜色，并且判断从u号点扩散开始染其他相连的点是否成功
    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = next[i]) {
            int b = e[i];
            if (color[b] == 0) {
                if (!dfs(b, 3 - c)) {
                    return false;
                }
            } else if (color[b] == c) {
                // 颜色重复
                return false;
            }
        }
        return true;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
