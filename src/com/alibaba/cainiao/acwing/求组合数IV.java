package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 求组合数IV {

    // https://www.acwing.com/solution/content/33254/
    // https://www.acwing.com/solution/content/32040/

    static Scanner in = new Scanner(System.in);
    static int N = 5009;
    static boolean[] st = new boolean[N];
    static int cnt;
    static int[] primes = new int[N];
    static int[] sum = new int[N];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int a = in.nextInt();
        int b = in.nextInt();
        getPrimes(a);

        // 因为线性筛法每循环一次cnt就会++，所以不能等于
        for (int i = 0; i < cnt; i++) {
            int t = primes[i];
            sum[i] = get(a, t) - get(b, t) - get(a - b, t);
        }

        list.add(1);                                // 从1开始乘，否则会为0
        for (int i = 0; i < cnt; i++) {             // 循环所有质数
            for (int j = 1; j <= sum[i]; j++) {     // 循环所有质数出现的次数
                list = multiply(list, primes[i]);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }

    // 高精度乘法
    private static List<Integer> multiply(List<Integer> l, int b) {
        int t = 0;
        for (int i = 0; i < l.size(); i++) {
            t += l.get(i) * b;
            l.set(i, t % 10);
            t /= 10;
        }

        while (t != 0) {
            l.add(t % 10);
            t /= 10;
        }
        return l;
    }

    // 返回n!中所有质数出现的次数
    private static int get(int n, int p) {
        int res = 0;
        while (n != 0) {
            res += n / p;
            n /= p;
        }
        return res;
    }

    // 1~n中质数的个数筛质数
    private static void getPrimes(int n) {
        //外层从2~n迭代
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
    }
}
