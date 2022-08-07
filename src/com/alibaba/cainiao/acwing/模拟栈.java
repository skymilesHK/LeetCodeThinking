package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 模拟栈 {

    static Scanner in = new Scanner(System.in);
    // tt 是栈顶指针
    static int m = 0, x = 0, tt = 0;
    static int N = (int) (1E5 + 9);
    static int[] stk = new int[N];

    public static void main(String[] args) {
        m = in.nextInt();
        do {
            String op = in.next();
            if ("push".equals(op)) {
                x = in.nextInt();
                stk[++tt] = x;
            } else if ("pop".equals(op)) {
                tt--;
            } else if ("empty".equals(op)) {
                System.out.println(tt <= 0 ? "YES" : "NO");
            } else {
                System.out.println(stk[tt]);
            }
        } while (--m > 0);
    }

}
