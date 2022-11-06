package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 模拟队列 {

    static int N = (int) (1E5 + 1), n;
    static int[] q = new int[N];
    // 代表队头指针,用于出队列
    static int hh = 0;
    // 代表队尾指针,用于进队列
    static int tt = -1;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        while (n-- > 0) {
            String c = in.next();
            switch (c) {
                case "push":
                    int x = in.nextInt();
                    push(x);
                    break;
                case "pop":
                    pop();
                    break;
                case "empty":
                    empty();
                    break;
                case "query":
                    query();
                    break;
                default:
                    break;
            }
        }
    }

    private static void push(int x) {
        q[++tt] = x;
    }

    static void pop() {
        q[hh] = 0;
        hh++;
    }

    static void query() {
        System.out.println(q[hh]);
    }

    static void empty() {
        if (hh <= tt) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
