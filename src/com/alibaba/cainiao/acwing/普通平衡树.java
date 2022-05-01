package com.alibaba.cainiao.acwing;

import java.util.Random;
import java.util.Scanner;

public class 普通平衡树 {

//    static int N = 100001, n = 0;
//    static int INF = (int) 1e8;
//    static TNode[] tr = new TNode[N];
//    static int root = 0, idx = 0;
//    static Random rand = new Random(System.currentTimeMillis());
//    static Scanner in = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        build();
//        n = in.nextInt();
//        for (int i = 1; i <= n; i++) {
//            int op = in.nextInt();
//            int x = in.nextInt();
//            switch (op) {
//                case 1:
//                    insert(root, x);
//                    break;
//                case 2:
//                    remove(root, x);
//                    break;
//                case 3:
//                    getRankByKey(root, x);
//                    break;
//                case 4:
//                    getKeyByRank(root, x);
//                    break;
//                case 5:
//                    getPrev(root, x);
//                    break;
//                case 6:
//                    getNext(root, x);
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//
//    // 右旋
//    public static void zig(int p) {
//        // q是p左儿子
//        int q = tr[p].l;
//        // p的左儿子是q的右儿子
//        tr[p].l = tr[q].r;
//        tr[q].r = p;
//        // p再变回根
//        p = q;
//
//        // 更新p.r
//        pushup(tr[p].r);
//        pushup(p);
//    }
//
//    // 左旋
//    public static void zag(int p) {
//        int q = tr[p].r;
//        // p的右儿子是q的左儿子
//        tr[p].r = tr[q].l;
//        // q的左儿子是p
//        tr[q].l = p;
//        p = q;//p再变回根
//        pushup(tr[p].l);
//        pushup(p);
//    }
//
//    // 通过排名找数值
//    public static void getKeyByRank(int root, int x) {
//
//    }
//
//    // 通过数值找排名
//    public static int getRankByKey(int p, int key) {
//
//    }
//
//    public static void remove(int p, int key) {
//        if (p == 0) {
//            return;
//        }
//        // 要删除当前节点
//        if(tr[p].key == key) {
//            if (tr[p].cnt > 1) {
//                tr[p].cnt--;
//            } else if (tr[p].l != 0 || tr[p].r != 0) {
//
//            } else {
//                // 不存在左右子树,是叶子节点
//                p = 0;
//            }
//        }
//    }
//
//    // 用p的子节点信息更新父节点信息
//    public static void pushup(int p) {
//        int left = tr[p].l;
//        int right = tr[p].r;
//        tr[p].size = tr[left].size + tr[right].size + tr[p].cnt;
//    }
//
//    //插入值key,从根开始
//    public static void insert(int p, int key) {
//        if (p == 0) {
//            createNode(key);
//        } else if (tr[p].key == key) {
//            tr[p].cnt++;
//        } else if (tr[p].key > key) {
//            insert(tr[p].l, key);
//            // 由于在左子树插入,插入左侧后左子树val可能大于根节点,左大右旋,保证堆的性质
//            if (tr[tr[p].l].val > tr[p].val) {
//                zig(p);
//            }
//        } else {
//            insert(tr[p].r, key);
//            // 右大左旋
//            if (tr[tr[p].r].val > tr[p].val) {
//                zag(p);
//            }
//        }
//
//        // p是每一层的根,指针,自底向上更新p
//        pushup(p);
//    }
//
//    public static int createNode(int key) {
//        tr[++idx].key = key;
//        tr[idx].val = rand.nextInt(N);
//        tr[idx].cnt = tr[idx].size = 1;
//        return idx;
//    }
//
//    // 初始化平衡树 左右哨兵
//    // y总:如果查询的结果可能不存在，那加上哨兵之后可以保证查询的结果一定存在，就不需要在查询过程中特判无解的
//    public static void build() {
//        createNode(-INF);
//        createNode(INF);
//        root = 1;
//        tr[1].r = 2;
//        // 更新root的size
//        pushup(root);
//    }
//
//    static class TNode {
//        int l, r;
//        int key, val;
//        int cnt, size;
//    }
}
