package com.alibaba.cainiao.template;

import java.util.Scanner;

public class 试除法分解质因数 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int x = in.nextInt();
        dividePrimeList(x);
    }

    private static void dividePrimeList(int x) {
        for (int i = 2; i <= x; i++) {
            if (x % i == 0) {
                // 这里每个i都是质数
                int cnt = 0;
                while (x % i == 0) {
                    cnt++;
                    x /= i;
                }

                System.out.printf("%d, %d\n", i, cnt);
            }
        }

        // x中那个只有一个 > √x 的质因数
        if (x > 1) {
            System.out.printf("%d, %d\n", x, 1);
        }
    }
}
