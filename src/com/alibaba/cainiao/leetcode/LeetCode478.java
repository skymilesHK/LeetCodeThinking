package com.alibaba.cainiao.leetcode;

import java.util.Random;

/**
 * 478. 在圆内随机生成点
 * 给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
 *
 * 说明:
 *
 * 输入值和输出值都将是浮点数。
 * 圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
 * 圆周上的点也认为是在圆中。
 * randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。
 * 示例 1：
 *
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * 输出: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * 示例 2：
 *
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * 输出: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 * 输入语法说明：
 *
 * 输入是两个列表：调用成员函数名和调用的参数。Solution 的构造函数有三个参数，圆的半径、圆心的 x 坐标、圆心的 y 坐标。randPoint 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 */
public class LeetCode478 {

    double r;
    double x;
    double y;
    Random random = new Random(System.currentTimeMillis());

    public LeetCode478(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        //先[0.0,1.0]随机生成，矩形区间的
        double i = random.nextDouble() * 2 - 1;
        double j = random.nextDouble() * 2 - 1;
        //去掉 圆外的，https://baike.baidu.com/item/%E5%9C%86%E7%9A%84%E6%A0%87%E5%87%86%E6%96%B9%E7%A8%8B
        //单位圆坐标表示(x-a)^2+(y-b)^2=r^2,这里不用开方
        if (i * i + j * j > 1) {
            return randPoint();
        }

        //圆等比例放大后的点
        return new double[] {x + r * i, y + r * j};
    }
}
