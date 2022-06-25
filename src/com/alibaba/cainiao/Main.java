package com.alibaba.cainiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static int n = 0;
    static List<PII> list = new ArrayList<>();

    public static void main(String[] args) {
        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list.add(new PII(a, b));
        }

        // 按右端点排序
        Collections.sort(list);

        // res表示当前点的数量，pre表示上一个区间的右端点
        int res = 0, pre = -0x3f3f3f;
        for (int i = 0; i < n; i++) {
            // 如果当前区间的左端点>上一个区间的右端点
            // 更新pre，res+1
            if (list.get(i).left > pre) {
                res++;
                pre = list.get(i).right;
            }
        }

        System.out.println(res);
    }

    static class PII implements Comparable<PII> {

        int left;
        int right;

        public PII(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(PII o) {
            return right - o.right;
        }
    }
}
