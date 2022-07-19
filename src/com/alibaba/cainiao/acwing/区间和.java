package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 区间和 {
    // https://www.acwing.com/solution/content/6055/
    // https://www.acwing.com/solution/content/13511/
    static int N = 300003;    //坐标x的数量上限为1e5，两个坐标l,r的数量上限也为1e5,所以加起来为3*le5;
    static int m, n;
    static int[] s = new int[N];
    static int[] a = new int[N];
    static List<Integer> alls = new ArrayList<>();          //存储所有查询/插入的坐标,等待离散化
    static List<Pair> addPairs = new ArrayList<>();         //存储所有的添加操作pair
    static List<Pair> queryPairs = new ArrayList<>();       //存储所有的查询操作pair
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int c = in.nextInt();

            addPairs.add(new Pair(x, c));
            alls.add(x);
        }

        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            queryPairs.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }

        alls = alls.stream().distinct().collect(Collectors.toList());

        for (Pair p : addPairs) {
            int x = find(p.first);
            a[x] += p.second;
        }

        //前缀和
        for (int i = 1; i <= alls.size(); i++) {
            s[i] = s[i - 1] + a[i];
        }

        //处理后m次询问操作
        for (Pair p : queryPairs) {
            int l = find(p.first);
            int r = find(p.second);
            System.out.printf("%d\n", s[r] - s[l - 1]);
        }
    }

    private static int find(int x) {
        int start = 0, end = alls.size() - 1, mid;
        while (start + 1 < end) {
            mid = start + end >> 1;
            if (alls.get(mid) > x) {
                end = mid;
            } else if (alls.get(mid) < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (alls.get(start) == x) {
            return start + 1;
        } else {
            return end + 1;
        }
    }

    static class Pair {

        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }
}
