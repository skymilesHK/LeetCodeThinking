package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 友好城市 {
    // https://www.acwing.com/problem/content/1014/

    static int N = 5001;
    static int[] dp = new int[N];
    static Pair[] p;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        p = new Pair[n];
        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            p[i] = new Pair(l, r);
        }

        Arrays.sort(p);
        int res = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (p[j].right < p[i].right) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }


    static class Pair implements Comparable<Pair> {

        int left;
        int right;

        public Pair() {
        }

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pair o) {
            return this.left - o.left;
        }
    }
}

