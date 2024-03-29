package com.alibaba.cainiao.leetcode;

/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 如果相等,此节点就是要删除的节点

            if (root.left != null && root.right != null) {
                // 此节点有两个儿子,一般的删除策略是用其右子树最小的数据代替该节点的数据并递归的删除掉右子树中最小数据的节点。
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                root.val = temp.val;
                // 删除右子树中的最左边的节点
                root.right = deleteNode(root.right, temp.val);
            } else {
                // 此节点有1个或0个儿子
                TreeNode temp = root;

                if (root.left == null) {
                    // 有右儿子或者没有儿子
                    root = root.right;
                } else if (root.right == null) {
                    // 有左儿子
                    root = root.left;
                }
                temp = null;
            }
        }
        return root;
    }

}
