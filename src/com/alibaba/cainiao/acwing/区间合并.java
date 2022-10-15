package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 区间合并 {

    // https://www.acwing.com/problem/content/805/
    static int N = 100001, n = 0, res = 0, INF = 0x3f3f3f3f;
    static List<Pair> list = new ArrayList<>(N);
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            list.add(new Pair(l, r));
        }

        // 按照左端点排序
        Collections.sort(list);
        // 上一个Pair下标
        int lastStart = -INF;
        int lastEnd = -INF;

        for (Pair p : list) {
            // 当前区间的左端点严格大于上一区间的右端点
            if (p.left > lastEnd) {
                res++;
                lastStart = p.left;
                lastEnd = p.right;
            } else {
                // 当前区间的右端点更新为上一区间的右端点，达到区间延长的效果
                if (p.right > lastEnd && p.left >= lastStart) {
                    lastEnd = p.right;
                } else {
                    // 当前区间完全被上一区间覆盖，直接跳过
                    continue;
                }
            }
        }

        System.out.println(res);
    }

    static class Pair implements Comparable<Pair> {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.left, o.left);
        }
    }
}
