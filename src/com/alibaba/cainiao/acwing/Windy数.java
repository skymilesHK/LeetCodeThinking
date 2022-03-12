package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Windy数 {

    // https://www.acwing.com/solution/content/60757/
    static int N = 12, l = 0, r = 0;
    static int[][] c = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        l = in.nextInt();
        r = in.nextInt();

        System.out.println(counter(r) - counter(l - 1));
    }

    private static int counter(int n) {
        if (n == 0) {
            return 0;
        }

        List<Integer> nums = new ArrayList<>(16);
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        // res记录总的方案数、last记录上一位的数
        int res = 0, last = -2;
        // 处理无前导零的情况(为n位的情况)
        for (int i = nums.size() - 1; i >= 0; i--) {
            // 取出该位上的数字
            int x = nums.get(i);
            // 左边,1~x-1
            for (int j = (i == nums.size() - 1) ? 1 : 0; j < x; j++) {
                if (Math.abs(j - last) >= 2) {
                    // 则将总方案数加上共有i + 1位(第0位 ~ 第i位)且最高位取j的方案数
                    res += c[i + 1][j];
                }
            }
            // 右边一位,该位就为x的情况
            if (Math.abs(x - last) >= 2) {
                last = x;
            } else {
                // 否则,说明不合法,即不能有继续的分支-->直接跳出
                break;
            }

            // 最后(最右侧)的情况
            if (i == 0) {
                res++;
            }
        }

        // 位数不足n位的情况，每种位数都会有一个答案，要枚举
        for (int i = 1; i < nums.size(); i++) { // 枚举位数
            for (int j = 1; j <= 9; j++) {      // 枚举最高位能取到的数
                res += c[i][j];
            }
        }
        return res;
    }

    // 可以有前导0的答案
    private static void init() {
        // 只有一位数的时候都为windy数,即方案数为1 (即边界情况)
        for (int j = 0; j <= 9; j++) {
            c[1][j] = 1;
        }

        // 枚举位数
        for (int i = 2; i < N; i++) {
            // 枚举当前位能取到的数
            for (int j = 0; j <= 9; j++) {
                // 枚举下一位能取到的数
                for (int k = 0; k <= 9; k++) {
                    if (Math.abs(j - k) >= 2) {
                        // 如果满足条件则加上对应的方案数
                        c[i][j] += c[i - 1][k];
                    }
                }
            }
        }

    }
}
