package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 排列数字 {

    // https://www.bilibili.com/video/BV1M4411Q7td/?spm_id_from=333.999.0.0&vd_source=19a205b524ff07cbc62a6f21c0c6b7c2  先看这个讲解
    // https://www.acwing.com/solution/content/4340/ 再看这个
    // https://www.acwing.com/solution/content/4775/  https://www.acwing.com/solution/content/4777/ 这两个是看变量命名
    // https://www.acwing.com/solution/content/14546/ 参考

    // 表示i这个位置是否已经使用过
    static boolean[] used = null;
    static int[] nums = null;
    static int[] path = null;
    static int n = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        path = new int[n];
        used = new boolean[n];
        nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        dfs(0);
    }

    /**
     * 枚举每个数放什么位置
     *
     * @param u 每个数字的下标
     */
    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%d ", path[i]);
            }
            System.out.println();
            return;
        }

        // 枚举每个位置
        for (int pathIdx = 0; pathIdx < n; pathIdx++) {
            // 如果该位置还没有放任何数
            if (!used[pathIdx]) {
                // 该位置放这个数
                path[pathIdx] = nums[u];
                used[pathIdx] = true;
                dfs(u + 1);
                used[pathIdx] = false;
                // path 不用回溯，会被覆盖
            }
        }
    }

}
