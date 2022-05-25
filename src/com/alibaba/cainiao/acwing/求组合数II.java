package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 求组合数II {

    // https://www.acwing.com/solution/content/22076/
    // https://www.acwing.com/solution/content/16482/
    static Scanner in = new Scanner(System.in);
    static int P = (int) 1e9 + 7, N = (int) 1e5 + 9;
    static long[] fact = new long[N];
    static long[] inFact = new long[N];

    public static void main(String[] args) {
        fact[0] = inFact[0] = 1;
        int n = in.nextInt();
        for (int i = 1; i < N; i++) {
            fact[i] = (int) (fact[i - 1] * i % P);
            inFact[i] = (int) (inFact[i - 1] * qmi(i, P - 2) % P);
        }

        do {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(fact[a] * inFact[b] % P * inFact[a - b] % P);
        } while (--n > 0);
    }

    // a^k % P
    private static long qmi(int a, int k) {
        long res = 1;
        while (k > 0) {
            // k的末尾是1
            if ((k & 1) != 0) {
                res = res * a % P;
            }
            // a不断平方
            a = (int) ((long) a * a % P);
            k >>= 1;
        }
        return (int) res;
    }

}
