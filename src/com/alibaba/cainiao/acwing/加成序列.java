package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 加成序列 {

    // https://www.acwing.com/solution/content/38248/
    // https://www.acwing.com/solution/content/121043/

    static int N = 102, n = 0;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            n = in.nextInt();
            if (n == 0) {
                break;
            }

            path[0] = 1;
            int depth = 1;
            while (!dfs(1, depth)) {
                depth++;
            }

            for (int i = 0; i < depth; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * u表示当前层数, d表示最大的层数
     *
     * @param u
     * @param d
     * @return
     */
    private static boolean dfs(int u, int d) {
        if (u >= d) {
            // 如果当前已经枚举到了最大深度，那么就返回path[u - 1] == n
            return path[u - 1] == n;
        }

        Arrays.fill(st, false);
        for (int i = u - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int s = path[i] + path[j]; //这是前两个数的和
                //s要大于上一个位置的数
                //不能大于输入的n
                //这个数没有被搜索过
                if (s > path[u - 1] && s <= n && !st[s]) {
                    st[s] = true;
                    // 将和 s 放到当前位置上（下次搜索直接覆盖就行，所以不需要恢复现场）
                    path[u] = s;
                    // 如果这个方案正确，返回true
                    if (dfs(u + 1, d)) {
                        return true;
                    }
                    // 这里不需要 st[s] = false; 回溯，因为在当前层每个和只能用一次
                }
            }
        }
        return false;
    }
}
