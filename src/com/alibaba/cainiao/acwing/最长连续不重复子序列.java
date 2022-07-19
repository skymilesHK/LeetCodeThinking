package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 最长连续不重复子序列 {

    static int N = 100009;
    //q[N]存储n个整数
    static int[] q = new int[N];
    //s[N]存储每个整数出现的次数
    static int[] s = new int[N];
    static int res = 1;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = in.nextInt();
        }

        for (int i = 0, j = 0; i < n; i++) {
            //i为右指针,j为左指针
            s[q[i]]++;
            while (j < i && s[q[i]] > 1) {
                s[q[i]]--;
            }

            res = Math.max(res, i - j + 1);
        }

        System.out.println(res);
    }

}
