package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 区间选点 {

    // https://www.acwing.com/solution/content/16905/ 图
    // https://www.acwing.com/solution/content/79913/ 解释

    // 最多有10w个区间
    static int N = 100001;
    static int n = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // 先将每个区间按右端点从小到大排序，然后每次枚举每个区间，当某个区间内已经取了点时，直接跳过即可，否则取每个区间最右端的端点。
        n = in.nextInt();
        List<PII> list = new ArrayList<>(n);
        // 读入n个区间
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list.add(new PII(a, b));
        }

        // 按右端点排序
        Collections.sort(list);
        // res表示当前点的数量，pre表示上一个区间的右端点
        int res = 0, pre = -100001;
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

    static class PII implements Comparable<PII> {

        int first;
        int second;

        public PII(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(PII o) {
            return second - o.second;
        }
    }
}
