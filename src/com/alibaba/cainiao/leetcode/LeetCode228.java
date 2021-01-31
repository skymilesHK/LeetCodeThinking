package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 难度
 * 简单
 *
 * 136
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 *
 * 输入：nums = [0]
 * 输出：["0"]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
public class LeetCode228 {
    // https://www.acwing.com/solution/content/19895/
    // 感觉这道题目标题应该改成汇总连续区间
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>(n);
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int l = 0, r = 1;
        // 因为结果集合是要枚举出起点，所以要按照l判断
        while (l < n) {
            // l是连续区间的起点，r往后走一直找连续区间的终点，[l,r - 1]指针维护的是当前连续的区间
            while (r < n && nums[r] - nums[r - 1] == 1) {
                r++;
            }

            if (l + 1 == r) {
                res.add(String.valueOf(nums[l]));
            } else {
                res.add(nums[l] + "->" + nums[r - 1]);
            }
            l = r++;
        }

        return res;
    }

}
