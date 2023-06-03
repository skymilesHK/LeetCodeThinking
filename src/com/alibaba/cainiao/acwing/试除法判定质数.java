package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 试除法判定质数 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();

        do {
            int x = in.nextInt();
            if (checkPrime(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } while (--n > 0);
    }

    private static boolean checkPrime(int x) {
        if (x < 2) {
            return false;
        }

        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

}
