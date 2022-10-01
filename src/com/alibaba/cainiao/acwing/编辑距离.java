package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 编辑距离 {

    //给定 n 个长度不超过 10 的字符串以及 m 次询问，每次询问给出一个字符串和一个操作次数上限。
    //
    //对于每次询问，请你求出给定的 n 个字符串中有多少个字符串可以在上限操作次数内经过操作变成询问给出的字符串。
    //
    //每个对字符串进行的单个字符的插入、删除或替换算作一次操作。
    //
    //输入格式
    //第一行包含两个整数 n 和 m。
    //
    //接下来 n 行，每行包含一个字符串，表示给定的字符串。
    //
    //再接下来 m 行，每行包含一个字符串和一个整数，表示一次询问。
    //
    //字符串中只包含小写字母，且长度均不超过 10。
    //
    //输出格式
    //输出共 m 行，每行输出一个整数作为结果，表示一次询问中满足条件的字符串个数。
    //
    //数据范围
    //1≤n,m≤1000,
    //
    //输入样例：
    //3 2
    //abc
    //acd
    //bcd
    //ab 1
    //acbd 2
    //输出样例：
    //1
    //3

    static Scanner in = new Scanner(System.in);
    static int N = 1002, M = 1002, n = 0, m = 0;
    // 所有把a中的前i个字母 变成 b中前j个字母的操作集合
    static int[][] dp = new int[N][N];
    static char[][] strs = new char[M][N];

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 1; i <= n; i++) {
            in.next();
        }
    }

}
