package com.alibaba.cainiao;

import java.util.Scanner;

public class Main {

    // 考虑最坏的情形，每个整数都单独形成了一条路径，因此存储每个整数都需要 31 个节点，存储 N 个整数需要 31N 个节点，算上最后的根节点一共有 31N+1 个
    static int N = 100001, M = 3100001, n = 0, idx = 0, res = 0;
    // 存输入的数字
    static int[] a = new int[N];
    // son数组 存输入数字二进制的每一位情况
    // 0表示不存在 其他表示存在并指向下一个son数组下标
    static int[][] son = new int[M][2];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

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


