package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 数字游戏 {
    static int N = 12, l = 0, r = 0;
    static int[][] c = new int[N][N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //预处理出c[i][j]表示：一共有i位，且最高位是j的数的个数
        init();
        while(in.hasNext()) {
            l = in.nextInt();
            r = in.nextInt();
            System.out.println(dp(r) - dp(l - 1));
        }
    }

    private static int dp(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        int last = 0;   //记录上一个数，因为开始时前面没有数字，因此不受限制，可以从0开始
        List<Integer> nums = new ArrayList<>(16);
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }

        for (int i = nums.size() - 1; i >= 0; i--) {
            int x = nums.get(i);
            //左分支
            for (int j = last; j < x; j++) {//为了保证不降序，枚举取到数从last开始，且为了最终的数字不超过，所以要<x
                res += c[i + 1][j];         //答案加上一共i+1位，且最高位为j的数的个数
            }
            if (x < last) {
                break;//如果降序，直接退出
            }
            last = x;//更新last

            if (i == 0) {
                res++;
            }
        }
        return res;
    }

    private static void init() {
        for (int j = 0; j <= 9; j++) {
            c[1][j] = 1;
        }

        for (int i = 2; i < N; i++) {           // i位
            for (int j = 0; j <= 9; j++) {      // 最高位是j
                for (int k = j; k <= 9; k++) {  // 枚举剩下有i-1位，且最高位为k的情况
                    c[i][j] += c[i - 1][k];
                }
            }
        }
    }
}
