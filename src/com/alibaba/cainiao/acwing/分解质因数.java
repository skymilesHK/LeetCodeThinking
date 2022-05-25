package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 分解质因数 {

    // https://www.acwing.com/problem/content/869/

    static int n = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        do {
            int x = in.nextInt();
            divide(x);
        } while (--n > 0);
    }

    private static void divide(int x) {
        for (int i = 2; i < x / i; i++) {
            // 这里每个i一定都是质数
            if (x % i == 0) {
                int c = 0;
                while (x % i == 0) {
                    x /= i;
                    c++;
                }
                System.out.printf("%d %d\n", x, c);
            }
        }

        // x中那个只有一个 > √x 的质因数
        if (x > 1) {
            System.out.printf("%d, %d\n", x, 1);
        }
    }

}
