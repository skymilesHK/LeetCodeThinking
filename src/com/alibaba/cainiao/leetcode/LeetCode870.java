package com.alibaba.cainiao.leetcode;

import java.util.Arrays;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 *
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 *
 *
 * 提示：
 *
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class LeetCode870 {
    // A: 2 7 11 15
    // B: 1 4 10 11
    // i: 0 2 1  3
    //res:2 11 7 15

    // 主要的思路:
    // 将问题转化成 以知B马出场顺序 以及B马的能力值 如何调整A的出场顺序 使能赢的场次最大

    // 将A马由大到小排序
    // B从大到小排序,并记录B马原来的出场顺序()
    // 比较A当前最小的马和B当前最小的马
    // 如果A最小的马<=B最小的马 则让A最小的马和B最大的马对
    // 如果A最小的马>B最小的马 则让A最小的马和B最小的马对
    public int[] advantageCount(int[] A, int[] B) {
        /*让A马从小到大排序*/
        Arrays.sort(A);
        int n = A.length;
        /*保存B马的位置*/
        int[][] sortB = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortB[i] = new int[] {B[i], i};
        }

        /*让B马从小到大排序*/
        Arrays.sort(sortB, (a, b) -> a[0] - b[0]);
        int[] res = new int[n];
        /*当前B最小的马*/
        int left = 0;
        /*当前B最大的马*/
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            /*当前的马比最小马小  就和他最大的马对*/
            if (A[i] <= sortB[left][0]) {
                /*更新B最大的马*/
                res[sortB[right--][1]] = A[i];
            } else {
                res[sortB[left++][1]] = A[i];
            }
        }
        return res;
    }
}
