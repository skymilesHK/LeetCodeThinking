package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 655. 输出二叉树
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 *
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * 示例 2:
 *
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * 示例 3:
 *
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 */
public class LeetCode655 {

    // 不会做, https://www.youtube.com/watch?v=ipIL1qVAazk&t=608s

    List<List<String>> list = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return list;
        }

        int h = getHeight(root);
        int w = (1 << h) - 1;
        String[][] res = new String[h][w];
        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i], "");
        }

        dfs(root, 0, 0, w - 1, res);

        // 转成List
        for (int i = 0; i < res.length; i++) {
            List<String> l = new ArrayList<>();
            for (int j = 0; j < res[0].length; j++) {
                String s = res[i][j] == null ? "" : res[i][j];
                l.add(s);
            }
            list.add(l);
        }

        return list;
    }

    private void dfs(TreeNode root, int d, int l, int r, String[][] res) {
        if (root == null) {
            return;
        }

        if (l > r) {
            return;
        }

        // root节点列位置
        int mid = l + (r - l) / 2;
        res[d][mid] = String.valueOf(root.val);
        dfs(root.left, d + 1, l, mid - 1, res);
        dfs(root.right, d + 1, mid + 1, r, res);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
