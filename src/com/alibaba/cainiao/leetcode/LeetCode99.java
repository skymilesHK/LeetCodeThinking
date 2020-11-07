package com.alibaba.cainiao.leetcode;

/**
 * 99. Recover Binary Search Tree
 * Hard
 *
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */


/**
 *     我们来分析下有哪些情况：1) 被交换的两个结点相邻，如124356，这样只需要把相邻的3和4交换回来即可；2) 被交换的两个结点不相邻，如163452，这样我们需要找出两个逆序的地方，63和52，并交换第一个逆序的前者和第二个逆序的后者。
 *
 *     我们如何做到一次DFS即可找出两个结点呢，并且空间为O(1)，用first和second两个指针存放要交换的两个结点是必要的，还需要一个pre指针在DFS过程中标记当前结点的前一个结点，以判断前后是否为逆序关系。
 *
 *     当第一次找到逆序时，如43，把first=3，second=4，如果后面没有发现第二个逆序，那么最后交换first和second即可。如果有两个逆序，如63和52，当我们发现第一个逆序63时，把first=6，second=3，然后发现第二个逆序52时，把second=2，最后交换first和second。
 *     (注意左子树和右子树的逻辑不太一样，需要独立思考运行逻辑)
 */
public class LeetCode99 {

    TreeNode pre;       // 指向当前遍历元素的前一个root节点
    TreeNode first;     // 第一个乱序的元素
    TreeNode second;    // 第二个乱序的元素

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root);
        if (first != null && second != null) {  // 只需要交换元素值，而没必要进行指针操作！
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (pre != null && pre.val > root.val) {
            if (first == null) {    // 找到第一个乱序的元素, 中序遍历寻找逆序情况，调换的第一个元素，永远是第一个逆序的第一个元素，而调换的第二个元素如果只有一次逆序，则是那一次的后一个
                first = pre;
            }
            second = root;          // 第二个乱序的元素。如果用了else，则无法通过只有两个元素的情况
        }
        pre = root;

        inOrder(root.right);
    }

}
