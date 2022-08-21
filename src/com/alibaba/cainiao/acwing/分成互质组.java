package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 分成互质组 {

    // https://www.acwing.com/solution/content/116896/
    // https://www.acwing.com/solution/content/10364/
    static int N = 11, n, res = N;
    static int[] a = new int[N];
    // 所有集合，集合中存的是每个数得下标
    static int[][] group = new int[N][N];
    // 判断是不是用过
    static boolean[] st = new boolean[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        dfs(1, 0, 0, 0);
        System.out.println(res);
    }

    /**
     * 当前是第几组，当前组中有多少个数，全部数中已经搜索了多少个数，从几个数开始搜
     *
     * @param gr
     * @param gc
     * @param cnt
     * @param start
     */
    private static void dfs(int gr, int gc, int cnt, int start) {
        // 如果组数超过了我们的答案最小组数，直接返回
        if (gr >= res) {
            return;
        }

        // 如果全部数已经搜完了，能够执行到这里，就说明组数比答案小，直接赋值
        if (cnt == n) {
            res = gr;
        }

        // 从start开始找，是否有元素不能放到gr组中
        boolean flag = true;
        for (int i = start; i < n; i++) {
            // 尝试放
            if (!st[i] && check(group[gr], gc, i)) {
                // 如果组中有数可以放入，那就不用重开新组
                flag = false;
                st[i] = true;
                group[gr][gc] = i;
                dfs(gr, gc + 1, cnt + 1, i + 1);
                st[i] = false;
            }
        }

        // 新开一个分组
        // 由于dfs每层之间确定了顺序，所以期间是会有元素被漏掉的，【比如一开始你找的一串序列(1)是1,2,3,4 但是第二次(2)是1,3,4 很显然此时
        // (2)还有一个3没有得到分组，需要从start=0开始再把它找出来！  因此这样做仿佛有点浪费时间呢！！】

        // 因此当所有元素都不能放进当前分组的时候 或者 当start=n-1了但是元素没有全部分组完毕时，要重新从start=0开始找，并且一定要有st数组！！！不然会把一个元素重复的分组！
        if (flag) {
            dfs(gr + 1, 0, cnt, 0);
        }
    }

    /**
     * 检查集合中元素是不是跟这个数是互质的
     *
     * @param g  某个集合
     * @param gc 集合当前层数中有多少个数
     * @param t  要比较的数下标
     * @return
     */
    private static boolean check(int[] g, int gc, int t) {
        for (int i = 0; i < gc; i++) {
            // 如果最大公约数大于1，说明两个数不互质
            if (gcd(a[g[i]], a[t]) > 1) {
                return false;
            }
        }
        return true;
    }

    private static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
