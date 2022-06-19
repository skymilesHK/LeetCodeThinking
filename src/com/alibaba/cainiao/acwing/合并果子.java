package com.alibaba.cainiao.acwing;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 合并果子 {
    // https://www.bilibili.com/video/BV1hK4y1k7Wr?spm_id_from=333.337.search-card.all.click&vd_source=19a205b524ff07cbc62a6f21c0c6b7c2 哈夫曼树

    static Scanner in = new Scanner(System.in);
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            pq.offer(in.nextInt());
        }

        int sum = 0;
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            int cur = a + b;
            sum += cur;
            pq.offer(cur);
        }
        System.out.println(sum);
    }
}
