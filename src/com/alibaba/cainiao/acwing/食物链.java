package com.alibaba.cainiao.acwing;

import java.util.Scanner;

public class 食物链 {

    static int N = 50002;
    static int n, k, res;
    static int[] parent = new int[N];
    static int[] dist = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        k = in.nextInt();
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        do {
            // d--> 说法种类
            // x--> 吃的物
            // y--> 被吃的物
            int d = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            if (x > n || y > n) {
                res++;
            } else {
                // 先找到父节点
                int pRoot = find(x);
                int qRoot = find(y);
                // 同类
                if (d == 1) {
                    if (pRoot == qRoot && (dist[y] - dist[x]) % 3 != 0) {
                        res++;
                    } else if (pRoot != qRoot) {
                        // 当前不在同一集合中，无法判定为假。故为真，应加入同一集合表示存在同类关系
                        parent[pRoot] = qRoot;
                        dist[pRoot] = dist[y] - dist[x];
                    }
                } else {
                    // 为吃被吃掉的关系
                    if (pRoot == qRoot && (dist[x] - dist[y] - 1) % 3 != 0) {
                        res++;
                    } else if (pRoot != qRoot) {
                        // 如果不在同一集合内，并到一起，更新距离
                        parent[pRoot] = qRoot;
                        dist[pRoot] = dist[y] + 1 - dist[x];
                    }
                }
            }
        } while (--k > 0);

        System.out.println(res);
    }

    private static int find(int p) {
        if (p != parent[p]) {
            int r = find(parent[p]);                //先把父节点及以上压缩到树根
            dist[p] = dist[p] + dist[parent[p]];    //更新边权
            parent[p] = r;                          //父节点也压缩到树根
        }
        return parent[p];
    }
}
