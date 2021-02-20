package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 */
public class LeetCode658 {

    // https://leetcode-cn.com/problems/find-k-closest-elements/solution/dai-ma-xiang-xi-jie-shi-by-jawhiow/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;

            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
                start = mid;
            } else {
                end = mid;
            }
        }

        List<Integer> res = new ArrayList<>(arr.length);
        if (Math.abs(x - arr[start]) > Math.abs(x - arr[end])) {
            for (int i = end; i < end + k; i++) {
                res.add(arr[i]);
            }
        } else {
            for (int i = start; i < start + k; i++) {
                res.add(arr[i]);
            }
        }

        return res;
    }

}
