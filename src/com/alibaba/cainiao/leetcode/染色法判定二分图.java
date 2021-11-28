package com.alibaba.cainiao.leetcode;

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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);

        do {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        } while (--m > 0);

        //标记是否染色成功
        boolean flag = true;
        //枚举每个点
        for (int i = 1; i <= n; i++) {
            //若未染色
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

    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }

    //dfs(u,c)表示把u号点染色成c颜色，并且判断从u号点开始染其他相连的点是否成功
    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = next[i]) {
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j, 3 - c)) {
                    return false;
                }
            } else if (color[j] == c) {
                return false;   //颜色重复
            }
        }
        return true;
    }
}
