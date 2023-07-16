package com.alibaba.cainiao;

import java.util.Scanner;

public class Main {

    // 考虑最坏的情形，每个整数都单独形成了一条路径，因此存储每个整数都需要 31 个节点，存储 N 个整数需要 31N 个节点，算上最后的根节点一共有 31N+1 个
    static int N = 100001, M = 3100002, n = 0, idx = 0, res = 0;
    // 存输入的数字
    static int[] a = new int[N];
    // son数组 存输入数字二进制的每一位情况
    // 0表示不存在 其他表示存在并指向下一个son数组下标
    static int[][] son = new int[M][2];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            insert(a[i]);
            // t是a[i]的异或配偶
            int t = query(a[i]);
        }
    }

    private static void insert(int x) {
        // 类似指针，开始指向root节点，向下延伸, 表示当前节点的大致位置
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            // 转化为数字
            int u = x >> i & 1;
            if (son[p][u] == 0) {
                // 没有该子结点就创建一个
                son[p][u] = ++idx;
            }
            // 走到p的子结点
            p = son[p][u];
        }
    }

    // 返回x的异或配偶
    private static int query(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            // 先尝试另一个方向
            int u = x >> i & 1;
            // 如果可以走
            if (son[p][1 - u] != 0) {
                p = son[p][1 - u];
                res = res * 2 + (1 - u);    // 这个地方与十进制一样 n = n * 10 + x; 二进制就是 n = n * 2 + x;
            } else {
                // 不可以走
                p = son[p][u];
                res = res * 2 + u;
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


