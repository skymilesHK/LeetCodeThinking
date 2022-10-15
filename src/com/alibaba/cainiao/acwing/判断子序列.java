package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 判断子序列 {

    // https://www.acwing.com/activity/content/problem/content/2981/
    static int N = 100002, M = 100002, n, m;
    static boolean flag;
    static int[] a = new int[N];
    static int[] b = new int[M];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                i++;
            }
            j++;
        }

        if (i == n) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
