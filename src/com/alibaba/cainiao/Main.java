package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    // 头节点下标
    static int head;
    // i下标元素的值
    static int[] e;
    // next[i]表示下一个节点的下标
    static int[] next;
    // 当前可以用的哪个下标
    static int idx;
    static int N = (int) (1E5 + 1);
    static Scanner in = new Scanner(System.in);

    // head -> [] -> [] -> [] -> [] -> |
    //         0     k=1   2     idx
    //            next[k]=idx             next[idx]=2
    static void init() {
        head = -1;
        idx = 0;
        e = new int[N];
        next = new int[N];
    }

    /**
     * 将x插入头节点
     * @param x
     */
    public static void addToHead(int x) {
        next[idx] = head;
        e[idx] = x;
        head = idx;
        idx++;
    }

    /**
     * 将x这个点 插入到下标是k的点后面
     * @param k
     * @param x
     */
    public static void add(int k, int x) {
        e[idx] = x;         // 先把 x 这个值存下来
        next[idx] = next[k];// 把新点的指针插入k这个点指向的下一个位置
        next[k] = idx;
        idx++;
    }

    /**
     * 将位置 k 后面的点删除
     * @param k
     * @return
     */
    public static void remove(int k) {
        //e[k] = 0; 还原元素值
        next[k] = next[next[k]];
    }

    public static void main(String[] args) {
        init();
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

}