package com.alibaba.cainiao;

import java.util.Scanner;

public class Main {
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
                int xRoot = find(x);
                int yRoot = find(y);
                // 同类
                if (d == 1) {
                    if (xRoot == yRoot && (dist[y] - dist[x]) % 3 != 0) {
                        res++;
                    } else if (xRoot != yRoot) {
                        // 当前不在同一集合中，无法判定为假。故为真，应先加入同一集合表示存在同类关系
                        parent[xRoot] = yRoot;
                        dist[xRoot] = dist[y] - dist[x];
                    }
                } else {
                    // 为吃被吃掉的关系
                    if (xRoot == yRoot && (dist[x] - dist[y] - 1) % 3 != 0) {
                        res++;
                    } else if (xRoot != yRoot) {
                        // 如果不在同一集合内，并到一起，更新距离
                        parent[xRoot] = yRoot;
                        dist[xRoot] = dist[y] + 1 - dist[x];
                    }
                }
            }
        } while (--k > 0);

        System.out.println(res);
    }

    private static int find(int p) {
        if (p != parent[p]) {
            int r = find(parent[p]);                // 先把父节点及以上压缩到树根
            dist[p] = dist[p] + dist[parent[p]];    // 更新边权
            parent[p] = r;                          // 父节点也压缩到树根
        }
        return parent[p];
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


