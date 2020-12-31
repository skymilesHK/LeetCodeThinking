package com.alibaba.cainiao.leetcode;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        // 记住这个做法 , 本质=找某个数，其出现的次数比其他数出现的次数加起来都多
        // https://www.acwing.com/video/1548/
        // cur是当前库存最多的数字，curCnt是库存最多的数字出现的次数
        int cur = nums[0];
        int curCnt = 1;
        for (int x : nums) {
            if (x == cur) {
                curCnt++;
            } else {
                if (curCnt == 0) {
                    cur = x;
                    curCnt = 1;
                } else {
                    curCnt--;
                }
            }
        }

        return cur;
    }

}
