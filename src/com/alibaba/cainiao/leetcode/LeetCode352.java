package com.alibaba.cainiao.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 352. 将数据流变为多个不相交区间
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 *
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 *
 *
 * 进阶：
 * 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 *
 * 提示：
 * 特别感谢 @yunhong 提供了本问题和其测试用例。
 */
public class LeetCode352 {

    TreeMap<Integer, Integer> L;
    TreeMap<Integer, Integer> R;

    /** Initialize your data structure here. */
    public LeetCode352() {
        L = new TreeMap<>();
        R = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> maxFloor = L.floorEntry(val);
        //val已经属于某个区间
        if (maxFloor != null && maxFloor.getValue() >= val) {
            return;
        }

        Integer l = R.get(val - 1);
        Integer r = L.get(val + 1);
        if (l != null && r != null) { //分四种情况讨论
            R.remove(val - 1);
            L.remove(val + 1);
            R.put(r, l);
            L.put(l, r);
        } else if (l != null) {
            R.remove(val - 1);
            R.put(val, l);
            L.put(l, val);
        } else if (r != null) {
            L.remove(val + 1);
            L.put(val, r);
            R.put(r, val);
        } else {
            L.put(val, val) ;
            R.put(val, val) ;
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[L.size()][2] ;
        int idx = 0 ;
        for(Map.Entry<Integer,Integer> entry : L.entrySet()) {
            res[idx][0] = entry.getKey() ;
            res[idx++][1] = entry.getValue() ;
        }
        return res;
    }
}
