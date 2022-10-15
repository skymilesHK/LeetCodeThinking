package com.alibaba.cainiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // https://www.acwing.com/activity/content/code/content/39799/  y老师代码
    // https://www.acwing.com/solution/content/31442/  便于理解版本

    static int N = 100002;
    static int l, r, c, n, m;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            // 构建差分数组
            b[i] = a[i] - a[i - 1];
        }

        do {
            l = in.nextInt();
            r = in.nextInt();
            c = in.nextInt();
            // 将序列中[l, r]之间的每个数都加上c
            insert(l, r, c);
        } while (--m > 0);

        // 求原数组a插入元素后的值, 相当于求 b[n]的前缀和
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + b[i];
            System.out.printf("%d ", a[i]);
        }
    }

    private static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
    }
}
