package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 *
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 *
 *
 * 提示：
 *
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 */
public class LeetCode1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        Map<Integer/**和60的差值**/, Integer/**个数**/> map = new LinkedHashMap<>();
        for (int value : time) {
            int remainder = value % 60;
            if (map.containsKey(remainder)) {
                // 迭代累计方式
                // 找到第1个，后面再配对就是1种
                // 找到第2个，后面再配对就是2种
                res += map.get(remainder);
            }

            if (remainder == 0) {
                // 特殊处理：余数为0的配对也是余数为0的
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else {
                // 记录当前余数的配对余数
                int target = 60 - remainder;
                map.put(target, map.getOrDefault(target, 0) + 1);
            }
        }
        return res;
    }

}
