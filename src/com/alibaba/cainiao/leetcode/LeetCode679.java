package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 679. 24 Game
 * Hard
 *
 *
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
 *
 * Example 1:
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * Example 2:
 * Input: [1, 2, 1, 2]
 * Output: False
 * Note:
 * The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */
public class LeetCode679 {

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double) num);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return Math.abs(list.get(0)) - 24.0 < 0.0000001;
        }

        // 选取两个数字,那么需要二重循环枚举两个数字
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Double first = list.get(i);
                Double second = list.get(j);

                // 找到当前其他元素，加入新list
                List<Double> newList = new ArrayList<>(4);
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        newList.add(list.get(k));
                    }
                }


                for (double d : compute(first, second)) {
                    newList.add(d);
                    if (dfs(newList)) {
                        return true;
                    } else {
                        newList.remove(newList.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    private double[] compute(Double first, Double second) {
        return new double[] {first + second, first - second, second - first, first * second, first / second, second / first};
    }

}
