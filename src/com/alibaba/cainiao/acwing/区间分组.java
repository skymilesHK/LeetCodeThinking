package com.alibaba.cainiao.acwing;

import java.util.*;

public class 区间分组 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        List<PII> list = new ArrayList<PII>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            list.add(new PII(l, r));
        }

        //按左端点排序
        Collections.sort(list);

        //通过小根堆维护每组的尾端
        PriorityQueue<Integer> heap = new PriorityQueue<>();

    }

    static class PII implements Comparable<PII> {

        int left;
        int second;

        public PII(int left, int second) {
            this.left = left;
            this.second = second;
        }

        @Override
        public int compareTo(PII o) {
            return Integer.compare(left, o.left);
        }
    }
}
