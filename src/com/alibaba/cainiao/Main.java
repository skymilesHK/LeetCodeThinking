package com.alibaba.cainiao;

import java.util.*;

public class Main {

}


class UF {
    int[] parent;
    int[] h;

    public UF(int size) {
        parent = new int[size];
        h = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            h[i] = 1;
        }
    }

    public int getSize() {
        return parent.length;
    }

    public boolean union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return false;
        }

        if (h[pRoot] < h[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (h[pRoot] > h[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            h[qRoot]++;
        }
        return true;
    }

    public int find(int p) {
        if (p < 0 || p >= getSize()) {
            throw new IllegalArgumentException("p is out of bound");
        }

        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
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


