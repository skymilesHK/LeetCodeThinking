package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 木棒 {

    // https://www.acwing.com/solution/content/42932/

    // len表示枚举的木棒的长度，sum 表示木棒的总长度
    static int N = 66, n = 0, sum = 0, len = 0;
    static int[] w = new int[N];
    static boolean[] st = new boolean[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            n = in.nextInt();
            if (n == 0) {
                break;
            }
            Arrays.fill(st, false);
            sum = 0;
            len = 0;

            for (int i = 0; i < n; i++) {
                w[i] = in.nextInt();
                sum += w[i];
            }

            w = Arrays.stream(w).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

            len = 1;
            while (true) {
                //第0根木棒,拼接长度是0,第0根开始
                if (sum % len == 0 && dfs(0, 0, 0)) {
                    System.out.println(len);
                    break;
                }
                len++;

                if (len > sum) {
                    break;
                }
            }
        }
    }

    // u: 当前枚举到的木棒编号; s: 当前木棒长度; start: 当前枚举到的木棍编号
    private static boolean dfs(int u, int s, int start) {
        if (u * len == sum) {
            return true;
        }

        if (s == len) {
            return dfs(u + 1, 0, 0);
        }

        // 剪枝3-1
        for (int i = start; i < n; i++) {
            if (st[i]) {
                continue;
            }

            if (s + w[i] > len) {
                continue;
            }

            st[i] = true;
            if (dfs(u, s + w[i], i + 1)) {
                return true;
            }
            // 恢复现场
            st[i] = false;

            //剪枝3-3
            if (s == 0) {
                return false;
            }
            //剪枝3-4
            if (s + w[i] == len) {
                return false;
            }

            //剪枝3-2
            int j = i;
            while (j < n && w[i] == w[j]) {
                j++;
            }
            i = j - 1;
        }

        return false;
    }

}
