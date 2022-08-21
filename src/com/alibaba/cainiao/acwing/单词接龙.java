package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 单词接龙 {

    static int N = 21;
    static int n;
    static String[] word = new String[N];
    static String start;
    // 表示i位置子符串与j位置子符串拼接重合的最小长度
    static int[][] g = new int[N][N];
    // i位置的字符串的使用次数
    static int[] used = new int[N];
    static int res = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            word[i] = in.next();
        }

        start = in.next();
        // 预处理
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String a = word[i];
                String b = word[j];
                for (int k = 1; k < Math.min(a.length(), b.length()); k++) {
                    int lenA = a.length();
                    int lenB = b.length();
                    // a的后k个 = b的前k个
                    if (a.substring(lenA - k, lenA).equals(b.substring(0, k))) {
                        // 通过贪心的思想，两个字符串拼接，重合部分越短，拼接后的长度越长
                        g[i][j] = k;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            //若该单词的第一字母和start相同
            if (start.equals(word[i].substring(0, 1))) {
                dfs(word[i], i);
            }
        }

        System.out.println(res);
    }

    private static void dfs(String dragon, int lastIdx) {
        res = Math.max(dragon.length(), res);
        used[lastIdx]++;
        for (int i = 0; i < n; i++) {
            if (g[lastIdx][i] > 0 && used[i] < 2) {
                int k = g[lastIdx][i];
                dfs(dragon + word[i].substring(k), i);
            }
        }
        used[lastIdx]--;
    }
}
