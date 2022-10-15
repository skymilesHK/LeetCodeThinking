package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 二进制中1的个数 {

    static int n;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();

        do {
            int x = in.nextInt();
            int res = 0;
            while (x != 0) {
                x -= lowbit(x);
                res++;
            }
            System.out.print(res + " ");
        } while (--n > 0);
    }

    private static int lowbit(int x) {
        return x & -x;
    }
}
