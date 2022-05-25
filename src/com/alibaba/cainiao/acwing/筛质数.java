package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 筛质数 {

    static boolean[] st = null;
    static int cnt;
    static int[] primes;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        st = new boolean[n + 1];
        primes = new int[n + 1];
        getPrimeNum(n);
        System.out.println(cnt);
    }

    private static void getPrimeNum(int n) {
        //外层从2~n迭代，因为这毕竟算的是1~n中质数的个数，而不是某个数是不是质数的判定
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;

                for (int j = i + i; j <= n; j += i) {
                    st[j] = true;
                }
            }
        }
    }
}
