package com.alibaba.cainiao;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N = 100002;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //a为原数组，b为差分数组
        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        //进行n次插入，初始化差分数组
        for (int i = 1; i <= n; i++) {
            insert(b, i, i, a[i]);
        }

        while (m-- > 0) {
            int l, r, c;
            l = scanner.nextInt();
            r = scanner.nextInt();
            c = scanner.nextInt();
            insert(b, l, r, c);
        }
        //经过一系列插入操作后，现在答案数组应该是b数组的前缀和，让b数组变成b的前缀和。
        //公式 b[i] = b[i-1] + b[i]
        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        scanner.close();
    }

    //插入操作函数
    public static void insert(int[] a, int l, int r, int c) {
        a[l] += c;
        a[r + 1] -= c;
    }
}
