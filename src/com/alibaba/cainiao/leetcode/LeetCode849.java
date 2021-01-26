package com.alibaba.cainiao.leetcode;

/**
 * 到最近的人的最大距离
 * https://leetcode-cn.com/problems/maximize-distance-to-closest-person/
 */
public class LeetCode849 {

    public int maxDistToClosest(int[] seats) {
        int count1 = 0;
        int count2 = 0;
        int i = 0, j = seats.length - 1;
        // count1记录开头连续0的个数
        while (seats[i] == 0) {
            count1++;
            i++;
        }

        // count2记录结尾连续0的个数
        while (seats[j] == 0) {
            count2++;
            j--;
        }

        // midZeroMaxCnt记录从第一个1到最后一个1之间，连续0的最大值
        int midCnt = 0, midZeroMaxCnt = 0;
        for (int k = i + 1; k <= j; k++) {
            if (seats[k] == 0) {
                midCnt++;
            } else {
                midZeroMaxCnt = Math.max(midZeroMaxCnt, midCnt);
                midCnt = 0;
            }
        }

        return Math.max(Math.max(count1, count2), (midZeroMaxCnt + 1) / 2);
    }

}
