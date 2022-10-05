package com.alibaba.cainiao.acwing;

import java.util.*;

public class 区间分组 {
    // https://www.acwing.com/problem/content/908/

    static Scanner in = new Scanner(System.in);
    static int N = 100002, n = 0, res = 0x3f3f3f3f;
    static List<Pair> list;

    public static void main(String[] args) {
        n = in.nextInt();
        list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list.add(new Pair(a, b));
        }

        // 按左端点排序
        Collections.sort(list);
        // 通过小根堆维护每组的尾端maxR
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
        for (Pair p : list) {
            if (minHeap.isEmpty() || p.left <= minHeap.peek()) {
                //开新组=minHeap加入新的右端点
                minHeap.offer(p.right);
            } else {
                //更新小根堆
                minHeap.poll();
                minHeap.offer(p.right);
            }
        }

        System.out.println(minHeap.size());
    }

    static class Pair implements Comparable<Pair> {
        int left, right;

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
