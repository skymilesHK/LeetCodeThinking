package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class Trie字符串统计 {
    // https://www.acwing.com/solution/content/14695/
    // https://www.acwing.com/solution/content/5673/

    static int N = 100002;
    // son[][]存储当前节点的子节点，分支最多26条
    static int[][] son = new int[N][26];
    // cnt[]存储以某节点结尾的字符串个数（同时也起标记作用）
    static int[] cnt = new int[N];
    // idx表示当前要插入的节点是第几个,每创建一个节点值+1
    static int idx = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        while (n-- > 0) {
            String str = in.next();
            if (str.equals("I")) {
                insert(in.next().toCharArray());
            } else {
                System.out.println(query(in.next().toCharArray()));
            }
        }
    }

    private static int insert(char[] str) {
        // 类似指针，开始指向root节点，向下延伸, 表示当前节点的大致位置
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            // 将字母转化为数字
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                // 没有该子结点就创建一个
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        return cnt[p];
    }

    // 返回字符串出现的次数
    private static int query(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            // 该节点不存在，即该字符串不存在
            if (son[p][u] == 0) {
                return 0;
            }
            p = son[p][u];
        }
        // 返回字符串出现的次数
        return cnt[p];
    }

    private static boolean startsWith(char[] prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length; i++) {
            int u = prefix[i] - 'a';
            if (son[p][u] == 0) {
                return false;
            }
            p = son[p][u];
        }

        return true;
    }
}
