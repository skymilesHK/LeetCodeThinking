package com.alibaba.cainiao.acwing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 修剪草坪 {

    // https://www.acwing.com/solution/content/27326/
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] oil = new int[n + 1];
        int[] dist = new int[n + 1];
        long[] s = new long[2 * n + 1];
        boolean[] res = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            oil[i] = in.nextInt();
            dist[i] = in.nextInt();
            s[i] = s[i + n] = oil[i] - dist[i];
        }
        for (int i = 1; i <= 2 * n; i++) {
            s[i] += s[i - 1];
        }
        Deque<Integer> q = new LinkedList<>();
        // q.add(n * 2 + 1);
        for (int i = 2 * n; i >= 0; i--) {
            if (q.size() > 0 && q.getFirst() > i + n) {
                q.pollFirst();
            }
            if (i < n) {
                if (s[q.getFirst()] >= s[i]) {
                    res[i + 1] = true;
                }
            }
            while (q.size() > 0 && s[q.getLast()] >= s[i]) {
                q.pollLast();
            }
            q.add(i);
        }

        dist[0] = dist[n];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i + n] = oil[i] - dist[i - 1];
        }
        for (int i = 1; i <= 2 * n; i++) {
            s[i] += s[i - 1];
        }
        q = new LinkedList<>();
        for (int i = 1; i <= 2 * n; i++) {
            if (q.size() > 0 && q.getFirst() < i - n) {
                q.pollFirst();
            }
            if (i > n) {
                if (s[i] >= s[q.getFirst()]) {
                    res[i - n] = true;
                }
            }
            while (q.size() > 0 && s[q.getLast()] <= s[i]) {
                q.pollLast();
            }
            q.add(i);
        }

        for (int i = 1; i <= n; i++) {
            if (res[i]) {
                System.out.println("TAK");
            } else {
                System.out.println("NIE");
            }
        }

    }

}
