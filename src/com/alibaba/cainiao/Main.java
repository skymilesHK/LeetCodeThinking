package com.alibaba.cainiao;

import java.util.Scanner;

public class Main {

    static int N = 50001;
    static int n, k, res;
    static int[] parent = new int[N];
    static int[] d = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        k = in.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        do {
            // t--> 说法种类
            // x--> 吃的物
            // y--> 被吃的物
            int t = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();


        } while (--k > 0);
    }
}


