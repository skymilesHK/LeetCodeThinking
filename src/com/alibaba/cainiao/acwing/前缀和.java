package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 前缀和 {
    // 原数组: a[1], a[2], a[3], a[4], a[5], …, a[n]
    // 前缀和 Si为数组的前 i项和
    // 前缀和: S[i] = a[1] + a[2] + a[3] + … + a[i]
    static int N = 100009;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[N];
        // 注意这里是从 1开始的
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }


    }

}
