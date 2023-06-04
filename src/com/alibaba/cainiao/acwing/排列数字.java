package com.alibaba.cainiao.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 排列数字 {

    // https://www.bilibili.com/video/BV1M4411Q7td/?spm_id_from=333.999.0.0&vd_source=19a205b524ff07cbc62a6f21c0c6b7c2  先看这个讲解
    // https://www.acwing.com/solution/content/4340/ 再看这个
    // https://www.acwing.com/solution/content/4775/  https://www.acwing.com/solution/content/4777/ 这两个是看变量命名
    // https://www.acwing.com/solution/content/14546/ 参考

    // 表示i这个位的数是否已经使用过
    static boolean[] used = null;
    static int[] nums = null;
    static int n = 0;
    static List<List<Integer>> res = null;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        used = new boolean[n];
        nums = new int[n];
        res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        dfs(0, new ArrayList<>());

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.printf("%d ", res.get(i).get(j));
            }
            System.out.println();
        }
    }

    /**
     * 枚举每个位置放什么数
     *
     * @param pathIdx 每个位置的下标
     * @param path
     */
    private static void dfs(int pathIdx, List<Integer> path) {
        if (pathIdx == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 枚举可以选择哪些数
        for (int numIdx = 0; numIdx < n; numIdx++) {
            if (!used[numIdx]) {
                // 选择该数
                path.add(nums[numIdx]);
                used[numIdx] = true;
                dfs(pathIdx + 1, path);
                // 回溯
                path.remove(path.size() - 1);
                used[numIdx] = false;
            }
        }
    }
}
