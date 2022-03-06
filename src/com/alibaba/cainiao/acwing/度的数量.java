package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 度的数量 {

    static int N = 34, K = 0, B = 0, l = 0, r = 0;
    static int[][] c = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        l = in.nextInt();
        r = in.nextInt();
        K = in.nextInt();
        B = in.nextInt();
        cba();
        System.out.println(dp(r) - dp(l - 1));
    }

    // 求区间[0,n]中的 “满足条件的数” 的个数
    private static int dp(int n) {
        if (n == 0) {
            return 0;
        }

        List<Integer> nums = new ArrayList<>(32);
        while (n > 0) {
            nums.add(n % B);
            n /= B;
        }

        int res = 0;
        //last在数位dp中存的是：右边分支往下走的时候保存前面的信息
        //遍历当前位的时候，记录之前那些位已经占用多少个1，那么当前还能用的1的个数就是K-last
        int last = 0;
        //从最高位开始遍历每一位
        for (int i = nums.size() - 1; i >= 0; i--) {
            //取当前位上的数
            int x = nums.get(i);
            if (x > 0) {
                //当前位填0，从剩下的所有位（共有i位）中选K-last个数。对应于：左分支中0的情况，合法
                res += c[i][K - last];
                if (x == 1) {
                    last++;
                    //如果已经填的个数last > 需要填的个数K，不合法break
                    if (last > K) {
                        break;
                    }
                } else {
                    //当前位填1，从剩下的所有位（共有i位）中选K-last-1个数。对应于：左分支中填1的情况，合法
                    if (K - last - 1 >= 0) {
                        res += c[i][K - last - 1];//i个数中选K-last-1个数填1的组合数是多少
                    }
                    break;
                }
            }

            // 最后一个合法的
            if (i == 0 && last == K) {
                res++;
            }
        }
        return res;
    }

    private static void cba() {
        for (int b = 0; b < N; b++) {
            for (int a = 0; a <= b; a++) {
                if (a == 0) {
                    c[b][a] = 1;
                } else {
                    c[b][a] = c[b - 1][a] + c[b - 1][a - 1];
                }
            }
        }
    }
}
