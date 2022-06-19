package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 耍杂技的牛 {

    static Scanner in = new Scanner(System.in);
    static int N = 50009;
    static PII[] p = new PII[N];

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int w = in.nextInt();
            int s = in.nextInt();
            p[i] = new PII(w + s, w); // 存入（体重+强壮值，体重）
        }

        Arrays.sort(p, 0, n);
        int res = -0x3f3f3f3f;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int w = p[i].y;     // 体重
            int s = p[i].x - w; // 强壮值
            res = Math.max(res, sum - s);   // 减去的是最下面的一个人的强壮值
            sum += w;   //叠罗汉上去一个人就得叠加重量
        }
        System.out.println(res);
    }

    static class PII implements Comparable<PII> {
        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(PII o) {
            return Integer.compare(x, o.x);
        }
    }
}
