package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class LeetCode501 {

    int maxCount = 1;
    int count = 1;
    TreeNode pre = null;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[] {};
        }

        dfs(root);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (pre == null) {
            // 第一个节点
            count = 1;
        } else if (pre.val == root.val) {
            // 与前一个节点数值相同
            count++;
        } else {
            // 与前一个节点数值不同
            count = 1;
        }

        // 更新上一个节点
        pre = root;

        // 如果和最大值相同，放进list中
        if (count == maxCount) {
            list.add(root.val);
        }

        // 如果计数大于最大值
        if (count > maxCount) {
            maxCount = count;
            list.clear(); // 很关键的一步，不要忘记清空result，之前result里的元素都失效了
            list.add(root.val);
        }

        dfs(root.right);
    }

}
