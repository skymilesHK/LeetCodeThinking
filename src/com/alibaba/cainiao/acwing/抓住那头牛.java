package com.alibaba.cainiao.acwing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 抓住那头牛 {
    // https://www.acwing.com/solution/content/18881/

    static int n, k, N = 200001;
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] dist = new int[N];
    static int[] dx;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        k = in.nextInt();
        System.out.println(bfs());
    }

    private static int bfs() {
        Arrays.fill(dist, -1);
        q.offer(n);
        dist[n] = -1;

        while (!q.isEmpty()) {
            Integer t = q.poll();
            dx = new int[]{1, -1, t};

            for (int i = 0; i < 3; i++) {
                int a = t + dx[i];
                if (a >= 0 && a <= N && dist[a] == -1) {
                    dist[a] = dist[t] + 1;
                    if (a == k) {
                        return dist[a];
                    }
                    q.offer(a);
                }
            }
        }
        return -1;
    }

}
