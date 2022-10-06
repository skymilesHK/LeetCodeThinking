package com.alibaba.cainiao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Pair[] a;
    static int n;

    public static void main(String[] args) {
        n = in.nextInt();
        a = new Pair[n];
        for (int i = 0; i < n; i++) {
            int w = in.nextInt();
            int s = in.nextInt();
            // 存入（体重+强壮值，体重）
            a[i] = new Pair(w + s, w);
        }

        Arrays.sort(a);
        int res = -0x3f3f3f3f;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 体重
            int w = a[i].second;
            // 强壮值
            int s = a[i].first - w;
            // 减去的是最下面的一个人的强壮值
            res = Math.max(res, sum - s);
            //叠罗汉上去一个人就得叠加重量
            sum += w;
        }
        System.out.println(res);
    }

    static class Pair implements Comparable<Pair> {

        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return this.first - o.first;
        }
    }
}
