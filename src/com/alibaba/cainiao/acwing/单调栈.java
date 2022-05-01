package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 单调栈 {
    static int N = 100002, n = 0;
    static int[] stack = new int[N];
    static int tt = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            while (tt > 0 && stack[tt] >= x) {
                tt--;
            }

            if (tt > 0) {
                System.out.print(stack[tt] + " ");
            } else {
                System.out.print(-1  + " ");
            }

            stack[++tt] = x;
        }
    }
}
