package com.alibaba.cainiao.leetcode;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class LeetCode109 {
    // 解题思路
    // 首先，该题还是有难度的，但是我们换一个思路可能就会简单很多，即如果是将一个排序二叉树转换成链表，相信大多数同学都会做，无非是一个中序遍历。
    // 那么，这里讲链表转换成二叉树也是一样的思路，即一个中序遍历，其具体思路如下。

    // 按照中序遍历的思路，应该先生成左子树，然后是根节点，最后的右子树。那么，很明显这是一个递归的结构。那么剩下的问题就是如何确定递归的终止条件。
    // 因为在转换的过程中，需要计算各子链表的长度，那么这里就可以由此来终止递归，即当长度等于0时终止。

    // 先生成最左边的那个子树，然后是根节点，然后是右子树

    //之前做过一道是从sorted array转换到BinarySearchTree的，方法还是一样二分法。但是构造树的方法不是由顶至下了，是要由低至上的建立。
    // https://www.cnblogs.com/springfor/p/3884031.html
    ListNode h = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int n = 0;
        h = head;
        while (head != null) {
            head = head.next;
            n++;
        }
        return sortedListToBST(0, n - 1);
    }

    private TreeNode sortedListToBST(int l, int r) {
        if (l > r) {
            return null;
        } else {
            // 中序建立,先生成左子树，然后是根节点，最后的右子树
            int mid = l + (r - l) / 2;
            TreeNode left = sortedListToBST(l, mid - 1);
            TreeNode root = new TreeNode(h.val);
            h = h.next;
            root.left = left;
            root.right = sortedListToBST(mid + 1, r);
            return root;
        }
    }
}
