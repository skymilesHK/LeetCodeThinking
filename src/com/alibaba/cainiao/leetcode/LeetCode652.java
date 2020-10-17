package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
public class LeetCode652 {

    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return res;
        }

        String s = dfs(root);
        System.out.println(s);
        return res;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String levelString = root.val + ',' + dfs(root.left) + ',' + dfs(root.right);//当前子树
        map.put(levelString, map.getOrDefault(levelString, 0) + 1);//是否重复
        if (map.get(levelString) == 2) {
            res.add(root);
        }
        return levelString;
    }

}
