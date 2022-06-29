package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 差分 {

    // https://www.acwing.com/activity/content/code/content/39799/  y老师代码
    // https://www.acwing.com/solution/content/31442/  便于理解版本

    static int N = 100009;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            // 构建差分数组
            b[i] = a[i] - a[i - 1];
        }

        int l, r, c;
        while (m-- > 0) {
            l = in.nextInt();
            r = in.nextInt();
            c = in.nextInt();
            // 将序列中[l, r]之间的每个数都加上c
            insert(l, r, c);
        }

        for (int i = 1; i <= n; i++) {
            // 前缀和运算
            a[i] = b[i] + a[i - 1];
            System.out.printf("%d ", a[i]);
        }
    }

    private static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }
}
