package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 */
public class LeetCode894 {

    // https://www.bilibili.com/video/BV1rW411Z7Sb?from=search&seid=5620153377309604449
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if (N % 2 == 0) {
            return list;
        }

        if (N == 1) {
            TreeNode node = new TreeNode(0);
            list.add(node);
            return list;
        }

        // 左子树，数目必须是奇数，右子树，数目必须是奇数。所以i += 2, i表示左子树点数目
        for (int i = 1; i < N; i += 2) {
           for (TreeNode l : allPossibleFBT(i)) {
               for (TreeNode r : allPossibleFBT(N - i - 1)) {
                   // 后序
                   TreeNode root = new TreeNode(0);
                   root.left = l;
                   root.right = r;
                   list.add(root);
               }
           }
        }

        return list;
    }

}
