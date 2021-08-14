package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Split Array into Fibonacci Sequence
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 */
public class LeetCode842 {
    // https://www.acwing.com/video/2924/
    public List<Integer> splitIntoFibonacci(String s) {
        // 第二个串的起始位置
        for (int i = 1; i <= 10 && i < s.length(); i++) {
            // 第二个串的中间位置
            for (int j = i + 1;j <= 10 && j < s.length(); j++) {
                long first = Long.parseLong(s.substring(0, i));
                long second = Long.parseLong(s.substring(i, j));
                List<Integer> res = get(s, first, second);
                // 有结果组合直接结束
                if (!res.isEmpty()) {
                    return res;
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Integer> get(String s, long a, long b) {
        List<Integer> res = new ArrayList<Integer>(s.length() / 3);
        res.add((int) a);
        res.add((int) b);
        StringBuilder sb = new StringBuilder(String.valueOf(a)).append(b);
        while (sb.length() < s.length()) {
            long c = a + b;
            if (c > Integer.MAX_VALUE) {
                return Collections.emptyList();
            }

            res.add((int) (c));
            sb.append(c);
            a = b;
            b = c;
        }

        //长度一样，但是数值不一样
        if (!sb.toString().equals(s)) {
            return Collections.emptyList();
        }
        return res;
    }
}
