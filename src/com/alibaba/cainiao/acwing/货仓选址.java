package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 货仓选址 {

    // https://www.acwing.com/solution/content/5382/
    static Scanner in = new Scanner(System.in);
    static int n = 0, res = 0;
    static int[] a;

    public static void main(String[] args) {
        n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            // 答案加上商店到货仓距离
            res += Math.abs(a[i] - a[n / 2]);
        }
        System.out.println(res);
    }

}
