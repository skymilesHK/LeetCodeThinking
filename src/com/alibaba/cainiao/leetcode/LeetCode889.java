package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 * Medium
 *
 *
 * Return any binary tree that matches the given preorder and postorder traversals.
 *
 * Values in the traversals pre and post are distinct positive integers.
 *
 *
 *
 * Example 1:
 *
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 *
 * Note:
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class LeetCode889 {

    // 记录结点值在后序中的下标
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }

        return build(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) {
            // 没有结点，返回空
            return null;
        }

        // 前序第一个结点就是当前根结点
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart < preEnd) {
            int leftV = pre[preStart + 1]; //默认一定有左子树，左子树根结点下标即begin + 1
            int leftCnt = map.get(leftV) - postStart + 1; //计算左子树结点数,在post里面找分界点

            //递归构建子树
            root.left = build(pre, preStart + 1, preStart + leftCnt, post, postStart, postEnd);
            root.right = build(pre, preStart + leftCnt + 1, preEnd, post, postStart + leftCnt, postEnd);

        }
        return root;
    }

}
