package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 不要62 {

    static int N = 9, l = 0, r = 0;
    static int[][] c = new int[N][10];           // c[i][j] 表示 我们填到第i位，当第i位填j的时候有多少种合适的车牌
    static Scanner in = new Scanner(System.in);

    private static void init() {
        for (int j = 0; j <= 9; j++) {
            if (j != 4) {
                c[1][j] = 1;
            }
        }

        for (int i = 2; i < N; i++) {                   // i 位数
            for (int j = 0; j <= 9; j++) {              // 枚举最高位已经取得的数
                if (j == 4) {
                    continue;
                }
                for (int k = 0; k <= 9; k++) {          // 枚举下一位能取到的数
                    if (j == 6 && k == 2 || k == 4) {
                        continue;
                    }
                    c[i][j] += c[i - 1][k];
                }
            }
        }
    }

    // [0,n]里面有多少个数是满足要求的?
    private static int counter(int n) {
        if (n == 0) {
            return 1;
        }

        List<Integer> nums = new ArrayList<>(16);
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        int res = 0, last = 0; // last用来看上一位是不是6，如果是6 那么这一位我就不能填2了
        for (int i = nums.size() - 1; i >= 0; i--) {
            int x = nums.get(i);
            // 枚举左边
            for (int j = 0; j < x; j++) {
                if (j == 4 || last == 6 && j == 2) {
                    continue;
                }
                res += c[i + 1][j];
            }

            // 右边
            if (x == 4 || last == 6 && x == 2) {
                break;
            }

            last = x;
            if (i == 0) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        while (true) {
            l = in.nextInt();
            r = in.nextInt();
            if (l == 0 && r == 0) {
                break;
            }
            c = new int[N][10];
            init();
            System.out.println(counter(r) - counter(l - 1));
        }
    }

}
