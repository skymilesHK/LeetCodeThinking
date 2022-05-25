package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 快速幂 {

    static int n = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        do {
            long a = in.nextLong();
            long k = in.nextLong();
            long p = in.nextLong();
            System.out.println(qmi(a, k, p));
        } while (--n > 0);
    }

    // a^k % p
    private static long qmi(long a, long k, long p) {
        long res = 1;
        while (k > 0) {
            // k的末尾是1的话
            if ((k & 1) == 1) {
                res = res * a % p;
            }
            // k的末尾删除1
            k >>= 1;
            a = a * a % p;
        }
        return res;
    }

}
