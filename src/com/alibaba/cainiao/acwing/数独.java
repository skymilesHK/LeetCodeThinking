package com.alibaba.cainiao.acwing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 数独 {

    // https://www.acwing.com/solution/content/56364/
    // https://www.acwing.com/activity/content/code/content/2884883/
    // https://www.acwing.com/solution/content/31873/

    static int N = 9;
    static int[] rows = new int[N];         // 存放二进制状态
    static int[] cols = new int[N];         // 存放二进制状态
    static int[][] cells = new int[N][N];   // 存放二进制状态
    static int[] ones = new int[1 << N];                                //存取二进制表示的数state [0, 2^9-1] 中 1的个数
    static Map<Integer, Integer> map = new HashMap<>(512);   //存二进制数最后一个1的位置, map快速地找出这行哪一列可以填，比如map[(1000)2] = 3就知道第四列可以填1
    static char[] chs;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // 打表，快速地知道可以一个二进制state数字是第几位为1, ones记录每个状态有多少个1
        initTable();

        while (true) {
            String str = in.next();
            if ("end".equals(str)) {
                break;
            }

            chs = str.toCharArray();
            // 初始化rows,cols,cells
            init();

            // cnt代表着大九宫格中所有空位置状态的个数
            int cnt = 0;
            // i,j遍历的是大九宫格上每个格子的位置，k是chs[]中的位置
            for (int i = 0, k = 0; i < N; i++) {
                for (int j = 0; j < N; j++, k++) {
                    // 原始棋盘填充
                    if (chs[k] != '.') {
                        // 减1是为了让他可以对应0-8，而进行二进制的转换(其实就是指数)
                        int pow = chs[k] - '1';
                        // 如果初始给的九宫格中(i,j)这个位置上不是空,填进大九宫格
                        draw(i, j, pow, true);
                    } else {
                        cnt++;
                    }
                }
            }
            // 根据空格个数来查找
        }
    }

    /**
     * set = true则在x,y填上t, 否则 则把x,y处的数字删掉, t是0-8
     *
     * @param x
     * @param y
     * @param t   t是这一位的十进制数字
     * @param set
     */
    private static void draw(int x, int y, int t, boolean set) {
        // 二维坐标转为一维坐标
        if (set) {
            chs[x * N + y] = (char) ('1' + t);
        } else {
            chs[x * N + y] = '.';
        }

        int state = 1 << t;
        if (!set) {

        } else {

        }
    }

    /**
     * 初始化数的二进制全是1，表示均可以选择
     */
    private static void init() {
        Arrays.fill(rows, (1 << N) - 1);
        Arrays.fill(cols, (1 << N) - 1);
        for (int i = 0; i < 3; i++) {
            Arrays.fill(cells[i], (1 << N) - 1);
        }
    }

    private static void initTable() {
        for (int i = 0; i < N; i++) {
            map.put(1 << i, i);
        }

        for (int i = 0; i < 1 << N; i++) {
            for (int j = 0; j < N; j++) {
                // 某个二进制状态i下,有多少个1
                ones[i] += i >> j & 1;
            }
        }
    }
}
