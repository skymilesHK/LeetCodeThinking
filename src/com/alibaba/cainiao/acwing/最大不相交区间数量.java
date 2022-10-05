package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 最大不相交区间数量 {

    // https://www.acwing.com/solution/content/5749/

    static Scanner in = new Scanner(System.in);
    static int N = 100002, n = 0, res = 0;
    static List<Pair> list;

    public static void main(String[] args) {
        n = in.nextInt();
        list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list.add(new Pair(a, b));
        }

        // 按右端点排序
        Collections.sort(list);
        // res表示当前点的数量，pre表示上一个区间的右端点
        int pre = -0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            // 如果当前区间的左端点>上一个区间的右端点, 取区间最右端的端点
            if (list.get(i).first > pre) {
                res++;
                pre = list.get(i).second;
            } else {
                // 区间内已经取了点时，直接跳过即可
                continue;
            }
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
            return this.second - o.second;
        }
    }
}
