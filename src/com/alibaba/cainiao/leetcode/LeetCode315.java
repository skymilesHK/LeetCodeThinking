package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
public class LeetCode315 {
    // https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/shu-zhuang-shu-zu-by-liweiwei1419/
    private int n = 0;

    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        List<Integer> res = new ArrayList<>(n);
        if (n == 0) {
            return res;
        }

        // 为了数组排序
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int x : nums) {
            treeSet.add(x);
        }

        HashMap<Integer/**原始数字**/, Integer/**离散化后的数字**/> ranks = new HashMap<>();
        int rank = 0;
        for (Integer x : treeSet) {
            ranks.put(x, ++rank);
        }

        // nums  5,2,6,1
        // ranks 3,2,4,1
        BIT bit = new BIT();
        // 从右向左
        for (int i = n - 1; i >= 0; i--) {
            // 1.查询离散化后的排名
            rank = ranks.get(nums[i]);
            // 2、在树状数组排名的那个位置更新 + 1
            bit.update(rank, 1);
            // 3、查询一下小于等于"当前排名 - 1"的元素有多少
            res.add(bit.query(rank - 1));
        }
        Collections.reverse(res);
        return res;
    }

    private class BIT {
        // 树状数组的前缀和数组
        private int[] t;
        private int len;

        public BIT() {
            len = n;
            t = new int[n + 1];
        }

        /**
         * 单点更新，t这个点以及他的所有父节点t[i + lowbit(i)]都+k
         * @param i
         * @param k
         */
        public void update(int i, int k) {
            for (; i <= len; i = i + lowbit(i)) {
                t[i] = t[i] + k;
            }
        }

        /**
         * 区间查询，查询[1,i]
         * @param i
         * @return
         */
        public int query(int i) {
            int sum = 0;
            for (; i > 0; i = i - lowbit(i)) {
                sum = sum + t[i];
            }
            return sum;
        }

        private int lowbit(int i) {
            return i & -i;
        }
    }
}
