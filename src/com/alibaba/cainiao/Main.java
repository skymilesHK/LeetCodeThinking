package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    // 小Q在进行射击气球的游戏，
    // 如果小Q在连续T枪中打爆了所有颜色的气球，
    // 将得到一只QQ公仔作为奖励。（每种颜色的气球至少被打爆一只）。
    // 这个游戏中有m种不同颜色的气球，编号1到m。小Q一共有n发子弹，然后连续开了n枪。
    // 小Q想知道在这n枪中，打爆所有颜色的气球最少用了连续几枪？
    // 输入描述：第一行两个空格间隔的整数数n，m。n<=1000000 m<=2000第二行一共n个空格间隔的整数，分别表示每一枪打中的气球的颜色,0表示没打中任何颜色的气球。
    //
    // 输出描述：一个整数表示小Q打爆所有颜色气球用的最少枪数。
    // 如果小Q无法在这n枪打爆所有颜色的气球，则输出-1
    // 示例输入：12 5
    // 2 5 3 1 3 2 4 1 0 5 4 3
    // 输出：6
    // test12 52 5 3 1 3 2 4 1 5 0 4 35

    /**
     * 使用滑动窗口求解
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n是个子弹, m表示有几种不同颜色的气球
        int n = sc.nextInt(), m = sc.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }
        int res = minWindow(colors, m);
        System.out.println(res);
    }

    // 利用滑动窗口：
    // 利用指针i遍历整个数组，如果第一次遍历到某元素，则将在区间中的元素的cnt值加1
    // 当整个区间包含所有元素时，将begin向前移动，缩小区间长度，更新结果
    private static int minWindow(int[] nums, int m) {
        int cnt = m;                    //判断是否包含所有颜色
        int[] map = new int[m + 1];     //记录颜色出现的次数
        for (int i = 1; i <= m; i++) {
            map[i]++;
        }
        int begin = 0, end = 0;
        int width = Integer.MAX_VALUE;
        while (end < nums.length) {
            int endNum = nums[end++];
            if (map[endNum]-- > 0) {
                cnt--;
            }
            while (cnt == 0) {
                if (end - begin < width) {
                    width = end - begin;
                }
                int beginNum = nums[begin++];
                if (map[beginNum]++ == 0) {
                    cnt++;
                }
            }
        }
        return width == Integer.MAX_VALUE ? -1 : width;
    }

}