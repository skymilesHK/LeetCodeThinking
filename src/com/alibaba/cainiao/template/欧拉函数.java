package com.alibaba.cainiao.template;

import java.util.Scanner;

public class 欧拉函数 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        do {
            int x = in.nextInt();
            int res = x;
            // 分解质因数
            for (int i = 2; i <= x / i; i++) {
                if (x % i == 0) {
                    res = res / i * (i - 1);
                    while (x % i == 0) {
                        x /= i;
                    }
                }
            }

            if (x > 1) {
                res = res / x * (x - 1);
            }
            System.out.println(res);
        } while (--n > 0);

    }

}
