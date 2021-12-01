package com.alibaba.cainiao.template;

import java.util.Scanner;

public class 筛质数 {

    static boolean[] st = null;
    static int cnt;
    static int[] primes;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
            }

            //对于任意一个合数n，假设p[j]为n最小质因子，当p[j]<=x/i时，一定会被筛掉
            for (int j = 0; primes[j] <= n / i; j++) {
                //用最小质因子去筛合数
                st[primes[j] * i] = true;
                /**
                 * 1.i%p[j] == 0, p[j]定为数i的最小质因子，p[j]也定为p[j]*i最小质因子
                 * 2.i%p[j] != 0, p[j]定小于数i的所有质因子，所以p[j]也为p[j]*i最小质因子
                 */
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
    }
}
