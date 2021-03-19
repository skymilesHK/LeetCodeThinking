package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int N = 100009;
    static int M = 200009;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx = 0;
    static int[] color = null;

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    //dfs(u,c)表示把u号点染色成c颜色，并且判断从u号点开始染其他相连的点是否成功
    public static boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j, 3 - c)) return false;
            } else if (color[j] == c) return false;//颜色重复
        }
        return true;
    }

    public static void main(String[] args) throws IOException, IOException {
        Solution solution = new Solution();
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        solution.possibleBipartition(3, dislikes);
    }

}