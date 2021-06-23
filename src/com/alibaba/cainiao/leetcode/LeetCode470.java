package com.alibaba.cainiao.leetcode;

import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [7]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [8,4]
 * 示例 3:
 *
 * 输入: 3
 * 输出: [8,1,10]
 *
 *
 * 提示:
 *
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 *
 *
 * 进阶:
 *
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 */
public class LeetCode470 {
    // https://www.acwing.com/video/1879/ 代码
    // https://www.youtube.com/watch?v=Wyauxe92JJA 图
    public int rand10() {
        int a = rand7(), b = rand7();
        int c = (a - 1) * 7 + b;    // 1 ~ 49
        if (c > 40) {
            return rand10();
        }
        // 求0~9的余数所以要减去1 (0~39), 最后再+1是因为要生成人类小标数字
        return (c - 1) % 10 + 1;
    }

    Random random = new Random(System.currentTimeMillis());
    public int rand7() {
        return random.nextInt() % 7;
    }
}
