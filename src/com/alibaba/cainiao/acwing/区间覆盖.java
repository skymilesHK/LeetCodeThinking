package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 区间覆盖 {

    // https://www.acwing.com/solution/content/21186/
    static Scanner in = new Scanner(System.in);
    static List<PII> list = new ArrayList<>();
    static int start, end;
    static int n;

    public static void main(String[] args) {
        // 将所有区间按左端点从小到大进行排序
        // 从前往后枚举每个区间，在所有能覆盖start的区间中，选择右端点最大的区间，然后将start更新成右端点的最大值
        start = in.nextInt();
        end = in.nextInt();
        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            list.add(new PII(l, r));
        }

        // 按左端点排序
        Collections.sort(list);
        int res = 0;
        // 判断是否成功，初值为失败
        boolean flag = false;

        // 枚举每个区间
        for (int i = 0; i < n; i++) {
            int j = i;
            //标识是否可以完全覆盖start
            int r = Integer.MIN_VALUE;
            //判断左端点在st之前的区间，循环找到最大右端点
            while (j < n && list.get(j).left <= start) {
                r = Math.max(r, list.get(j).right);
                j++;
            }
            //如果右端点也在st之前，说明无法覆盖
            if (r < start) {
                res = -1;
                break;
            }

            //每循环一次，没有在前面跳出的话，说明找到了一个区间，res++
            res++;
            //如果这个区间右端点能覆盖end，说明能覆盖
            if (r >= end) {
                flag = true;
                break;
            }
            //把start更新成r，保证后面的区间适合之前的区间有交集，从而形成对整个序列的覆盖
            start = r;
            i = j - 1;
        }

        if(!flag) {
            res = -1;
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
            return Integer.compare(left, o.left);
        }
    }
}
