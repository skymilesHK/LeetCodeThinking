package com.alibaba.cainiao.leetcode;

/**
 * 237. Delete Node in a Linked List
 *
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class LeetCode237 {

    //题目说了node不是最后一个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
