package com.alibaba.cainiao.leetcode;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 *
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */
public class LeetCode449 {

    // https://www.bilibili.com/video/BV19t411w7Ep
    int res = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int singleLen = dfs(root);
        return res;
    }

    // dfs函数表示经过当前节点到(左或者右,只能是一个)的单边叶子节点的最大深度, root为最高点
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 向左右拿path长度
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        res = Math.max(res, leftLen + rightLen);

        // 这个返回的是路径数目不是节点数目，要+1
        return Math.max(leftLen, rightLen) + 1;
    }

}
