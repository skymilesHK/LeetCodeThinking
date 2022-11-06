package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 单链表 {

    // 数组模拟单链表demo
    // idx 表示下一个可以用的位置
    static int N = 100002, idx = 0, head = -1;
    // e[i]表示节点i的值
    static int[] e = new int[N];
    // next[i]表示节点i的值
    static int[] next = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        head = -1;
        idx = 0;

        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            String s = in.next();
            switch (s) {
                case "H": {
                    int x = in.nextInt();
                    addToHead(x);
                    break;
                }
                case "D": {
                    int k = in.nextInt();
                    if (k == 0) {
                        head = next[head];
                    } else {
                        remove(k - 1);
                    }
                    break;
                }
                case "I": {
                    int k = in.nextInt();
                    int x = in.nextInt();
                    add(k - 1, x);
                    break;
                }
                default:
                    break;
            }
        }

        for (int i = head; i != -1; i = next[i]) {
            System.out.print(e[i] + " ");
        }
    }

    /**
     * 将x插入头节点
     *
     * @param x
     */
    private static void addToHead(int x) {
        e[idx] = x;
        next[idx] = head;
        head = idx++;
    }

    /**
     * 将x这个点 插入到下标是k的点后面
     *
     * @param k
     * @param x
     */
    public static void add(int k, int x) {
        e[idx] = x;
        next[idx] = next[k];
        next[k] = idx++;
    }

    /**
     * 将位置 k 后面的点删除
     *
     * @param k
     * @return
     */
    private static void remove(int k) {
        //e[k] = 0; 还原元素值
        next[k] = next[next[k]];
    }
}
