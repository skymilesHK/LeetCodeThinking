package com.alibaba.cainiao.template;

public class 试除法判定质数 {
    public static void main(String[] args) {

    }

    private static boolean isPrime(int x) {
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
