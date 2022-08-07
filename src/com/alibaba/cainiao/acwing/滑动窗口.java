package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 滑动窗口 {

    static int N = 1000002, n = 0, k = 0;
    static int[] a = new int[N];
    // 队列存的是下标
    static int[] q = new int[N];
    static int hh = 0, tt = -1;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        k = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            // 判断队头元素是否滑出窗口
            while (hh <= tt && i - q[hh] + 1 > k) {
                hh++;
            }

            // 队尾判断大小
            while (hh <= tt && a[q[tt]] >= a[i]) {
                tt--;
            }

            // 入队
            q[++tt] = i;
            // 足k个输出
            if (i - k + 1 >= 0) {
                System.out.printf("%d ", a[q[hh]]);
            }
        }

        System.out.println();

        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            // 判断队头元素是否滑出窗口
            while (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }

            // 队尾判断大小
            while (hh <= tt && a[q[tt]] <= a[i]) {
                tt--;
            }

            // 足k个输出
            q[++tt] = i;
            if (i - k + 1 >= 0) {
                System.out.printf("%d ", a[q[hh]]);
            }
        }
    }

}
