package com.alibaba.cainiao.leetcode;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acwing.com/solution/content/5334/
public class 二分图的最大匹配 {

    static int N = 509, M = 100009;
    static int n1, n2, m;                   //左半部包含 n1 个点,右半部包含 n2 个点
    static int idx;
    static int[] h = new int[N];
    static int[] next = new int[M];
    static int[] e = new int[M];
    static boolean[] st = new boolean[N];   //st[]数组我称为临时预定数组，st[j]=a表示这一轮模拟匹配中，女孩j和男孩a匹配。
    static int[] match = new int[N];        //match[j]=a,表示女孩j的现有配对男友是a

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n1 = in.nextInt();
        n2 = in.nextInt();
        Arrays.fill(h, -1);
        do {
            int a = in.nextInt();
            int b = in.nextInt();
            // 特殊，虽然是无向边，但是不需要b-》a这条边 https://www.acwing.com/video/290/     17:00分钟
            add(a, b);
        } while (--m > 0);

        int res = 0;
        for (int i = 1; i <= n1; i++) {
            //因为每次模拟匹配的预定情况都是不一样的所以每轮模拟都要初始化
            st = new boolean[N];
            // 男生i
            if (find(i)) {
                res++;
            }
        }

        System.out.println(res);
    }

    //这个函数的作用是用来判断,如果加入x来参与模拟配对,会不会使匹配数增多
    private static boolean find(int a) {
        //遍历自己喜欢的女孩b,邻接点
        for (int i = h[a]; i != -1; i = next[i]) {
            int b = e[i];
            //如果在这一轮模拟匹配中,这个女孩尚未被预定的话
            if (!st[b]) {
                st[b] = true;
                //如果女孩b没有男朋友，或者 她原来的男朋友能够预定其它喜欢的女孩。 配对成功,更新match
                if (match[b] == 0 || find(match[b])) {
                    match[b] = a;
                    return true;
                }
            }
        }
        //自己中意的全部都被预定了。配对失败。
        return false;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        next[idx] = h[a];
        h[a] = idx++;
    }
}
