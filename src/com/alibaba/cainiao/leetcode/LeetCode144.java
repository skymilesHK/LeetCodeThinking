package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode144 {
    List<Integer> res = new ArrayList<>();

    // 递归版本
//    public List<Integer> preorderTraversal(TreeNode root) {
//        dfs(root);
//        return res;
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        res.add(root.val);
//        dfs(root.left);
//        dfs(root.right);
//    }

    // 非递归版本
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        var p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                p = t.right;
            }
        }

        return res;
    }
}
