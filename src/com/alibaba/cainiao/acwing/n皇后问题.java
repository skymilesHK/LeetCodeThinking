package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class n皇后问题 {

    static int N = 9, n = 0;
    static Scanner in = new Scanner(System.in);
    static boolean[] row = new boolean[N];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N + N];
    static boolean[] udg = new boolean[N + N];
    static char[][] g = new char[N][N];

    // https://www.acwing.com/solution/content/106979/
    // https://blog.csdn.net/weixin_49486457/article/details/123534983?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522168001275216800215028030%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=168001275216800215028030&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-1-123534983-null-null.blog_rank_default&utm_term=n%E7%9A%87%E5%90%8E&spm=1018.2226.3001.4450
    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        dfs(0);
    }

    // u是搜索的行
    static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // u是行, y是列
        for (int y = 0; y < n; y++) {
            // 这一列/正副对角线之前没有set过
            if (!col[y] && !dg[y + u] && !udg[y - u + n]) {
                g[u][y] = 'Q';
                col[y] = dg[u + y] = udg[y - u + n] = true;
                // 找下一层的
                dfs(u + 1);
                g[u][y] = '.';
                col[y] = dg[u + y] = udg[y - u + n] = false;
            }
        }
    }
}
