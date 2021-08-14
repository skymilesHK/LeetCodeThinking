package com.alibaba.cainiao.leetcode;

/**
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */
public class LeetCode861 {
    // https://www.acwing.com/activity/content/problem/content/3973/
    public int matrixScore(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        //第一列不变换，先考虑将那些行变换
        for(int i = 0; i < row; i++){
            //第i行需要反转一下
            if(grid[i][0] == 0){
                for(int j = 0; j < col; j++){
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        // for(int i = 0; i < row; i++){
        //     for(int j = 0; j < col; j++){
        //          System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int result = row * ( 1 << (col - 1));
        //考虑从第二列开始到最后一列
        for(int i = 1; i < col; i++){
            //观察第i列中0和1的个数，取二者中较大的值
            int cnt = 0;
            for(int j = 0; j < row; j++){
                if(grid[j][i] == 0) {
                    cnt++;
                }
            }
            // System.out.println("cnt is " + cnt);
            result += Integer.max(cnt, row - cnt) * (1 << (col - i - 1));
        }
        return result;
    }

}
