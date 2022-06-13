package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 最长上升子序列II {

    // https://www.acwing.com/video/328/

    static int N = 100009;
    static int[] a = new int[N];
    static int[] q = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        // q数组元素个数
        int len = 0;
        // q[len]表示长度是len的最长严格上升子序列，其结尾的值是q[len]
        q[0] = -0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            int start = 0, end = len, mid = 0;
            while (start + 1 < end) {
                mid = start + end >> 1;
                if (q[mid] < a[i]) {
                    start = mid;
                } else if (q[mid] > a[i]) {
                    end = mid;
                } else {
                    end--;
                }
            }
            //这里找到了左边最大的小于a[i]的数q[end], 此时的序列长度是原来的长度end 加上 1
            if (q[end] < a[i]) {
                // end是小于a[i]的最后一个数字
                len = Math.max(len, end + 1);
                // a[end + 1] 一定大于a[i]
                q[end + 1] = a[i];
            } else {
                // end是小于a[i]的最后一个数字
                len = Math.max(len, start + 1);
                // a[end + 1] 一定大于a[i]
                q[start + 1] = a[i];
            }
        }
        System.out.println(len);
    }

}
