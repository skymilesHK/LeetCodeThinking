package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 导弹防御系统 {
    // https://www.acwing.com/solution/content/46084/ 复习前一个
    // https://www.acwing.com/solution/content/10173/ 复习前一个
    // https://www.acwing.com/solution/content/52200/ 现题讲解
    // https://www.acwing.com/solution/content/45984/ 现题讲解

    static int N = 51;
    static int res;
    static int[] num = new int[N];
    static int[] up = new int[N];
    static int[] down = new int[N];
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            n = in.nextInt();
            if (n == 0) {
                break;
            }
            res = n;
            for (int i = 0; i < n; ++i) {
                num[i] = in.nextInt();
            }
            dfs(0, 0, 0);
            System.out.println(res);
        }
    }

    private static void dfs(int idx, int u, int d) {
        if (u + d >= res) {
            return;
        }
        if (idx == n) {
            res = u + d;
            return;
        }
        int k = 0;
        while (k < u && num[idx] <= up[k]) {
            k++;
        }
        int t = up[k];
        up[k] = num[idx];
        if (k < u) {
            dfs(idx + 1, u, d);
        } else {
            dfs(idx + 1, u + 1, d);
        }
        up[k] = t;

        k = 0;
        while (k < d && num[idx] >= down[k]) {
            k++;
        }
        t = down[k];
        down[k] = num[idx];
        if (k < d) {
            dfs(idx + 1, u, d);
        } else {
            dfs(idx + 1, u, d + 1);
        }
        down[k] = t;
    }

}
