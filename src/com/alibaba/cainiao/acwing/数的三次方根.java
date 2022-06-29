package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 数的三次方根 {

    // https://www.acwing.com/solution/content/17974/

    static Scanner in = new Scanner(System.in);
    static double x = 0.0;

    public static void main(String[] args) {
        x = in.nextDouble();
        double start = -10000.0, end = 10000.0, mid = 0.0;
        while (end - start > 1.0e-8) {
            mid = (start + end) / 2.0;
            if (mid * mid * mid > x) {
                end = mid;
            } else if (mid * mid * mid < x) {
                start = mid;
            } else {
                System.out.println(x);
                return;
            }
        }

        System.out.printf("%.6f", start);
    }

}
