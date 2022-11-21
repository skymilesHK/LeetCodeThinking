package com.alibaba.cainiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // assume no concurrency
    static List<List<Integer>> res = new ArrayList<>();
    // 表示i这个数字nums[i]是否已经使用过
    static boolean[] used = null;
    static int[] num = null;
    static int[] path = null;
    static int n = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        used = new boolean[n];
        num = new int[n];
        path = new int[n];

        for (int i = 1; i <= n; i++) {
            num[i - 1] = i;
        }

        dfs(num, 0);
        res.forEach(l -> {
            l.forEach(n -> System.out.printf("%d ", n));
            System.out.println();
        });
    }

    /**
     * 枚举每个位置放什么数
     *
     * @param num
     * @param u   当前枚举的位置
     */
    private static void dfs(int[] num, int u) {
        if (u == n) {
            res.add(Arrays.stream(path).boxed().collect(Collectors.toList()));
            return;
        }

        // 遍历每一个数字
        for (int i = 0; i < n; i++) {
            // 该数字没有使用过
            if (!used[i]) {
                used[i] = true;
                // 将未使用过的数字放到 指定位置
                path[u] = num[i];
                // 枚举下一个位置
                dfs(num, u + 1);
                // 恢复现场
                used[i] = false;
                //path[i] 不用恢复，每次会被覆盖。
            }
        }
    }
}


