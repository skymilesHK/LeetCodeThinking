package com.alibaba.cainiao.acwing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 约数之和 {

    // https://www.acwing.com/solution/content/16981/

    static int n = 0, MOD = (int) (1e9 + 7);
    static Map<Integer, Integer> primeMap = new HashMap<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        do {
            int x = in.nextInt();
            // 分解质因数
            divide(x);
        } while (--n > 0);

        long res = 1L;
        for (Map.Entry<Integer, Integer> entry : primeMap.entrySet()) {
            Integer p = entry.getKey();
            Integer a = entry.getValue();
            // p^0 + p^1 +...+p^a
            long t = 1L;
            do {
                t = (t * p + 1) % MOD;  // 多项式的一个项
            } while (--a > 0);

            res = res * t % MOD;        // 多项式的一个个项相乘
        }
        System.out.println(res);
    }

    private static void divide(int x) {
        for (int i = 2; i <= x / i; i++) {
            // 枚举每个数，看是不是因数
            if (x % i == 0) {
                // 说明是因数，不断继续切分，找质因数
                while (x % i == 0) {
                    x /= i;
                    primeMap.put(i, primeMap.getOrDefault(i, 0) + 1);
                }
            }
        }

        // 分解质因数,最多只有一个因数大于
        if (x > 1) {
            primeMap.put(x, primeMap.getOrDefault(x, 0) + 1);
        }
    }

}
