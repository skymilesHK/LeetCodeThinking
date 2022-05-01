package com.alibaba.cainiao;

import java.util.Scanner;

public class Main {
    static int N = 100007;
    static int[] h = new int[N];
    static int size;

    public static void swap(int u, int t) {
        int x = h[u];
        h[u] = h[t];
        h[t] = x;
    }

    //哪个位置下沉操作
    public static void down(int u) {
        int t = u;
        if (u * 2 <= size && h[u * 2] < h[t]) t = u * 2;
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
        if (u != t) {
            swap(u, t);//交换u和t位置的值
            down(t);
        }
    }

    //哪个位置上升
    public static void up(int u) {
        while (u / 2 > 0 && h[u] < h[u / 2]) {
            swap(u, u / 2);
            u /= 2;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        size = n;
        for (int i = 1; i <= n; i++) h[i] = scan.nextInt();

        //O(n)的复杂度进行堆化
        for (int i = n / 2; i >= 1; i--) down(i);

        while (m-- > 0) {
            System.out.print(h[1] + " ");
            h[1] = h[size--];
            down(1);
        }

    }

}
