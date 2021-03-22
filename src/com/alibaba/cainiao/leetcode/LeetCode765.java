package com.alibaba.cainiao.leetcode;

/**
 * 765. 情侣牵手
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 *
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 *
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 *
 * 示例 1:
 *
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 示例 2:
 *
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * 说明:
 *
 * len(row) 是偶数且数值在 [4, 60]范围内。
 * 可以保证row 是序列 0...len(row)-1 的一个全排列。
 */
public class LeetCode765 {
    // https://www.bilibili.com/video/BV1pv411Y7wX?from=search&seid=14701591895267099720
    // https://www.acwing.com/solution/content/3957/  错误环数量=连通分量数量=找连通分量数目
    public int minSwapsCouples(int[] row) {
        // 情侣对数
        int N = row.length / 2;
        UF uf = new UF(N);
        // 相邻两位合并
        for (int i = 0; i < row.length; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        // 所有情侣交换之前的错误环数量-交换之后的错误环数量
        return N - uf.cnt;
    }

    class UF {
        int[] parent;
        int[] h;
        int cnt;

        public UF(int size) {
            parent = new int[size];
            h = new int[size];
            cnt = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                h[i] = 1;
            }
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }

            if (h[pRoot] < h[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (h[pRoot] > h[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                h[qRoot]++;
            }
            cnt--;
        }

        private int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}
