package com.alibaba.cainiao.leetcode;

// https://leetcode.com/problems/design-linked-list/
public class LeetCode707MyLinkedList {

    private class MyLinkedListNode {
        public int val;
        public MyLinkedListNode next;

        public MyLinkedListNode(int val) {
            this.val = val;
        }
    }

    private MyLinkedListNode dummyHead;
    private int size;

    /** Initialize your data structure here. */
    public LeetCode707MyLinkedList() {
        dummyHead = new MyLinkedListNode(-1);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of range");
        }
        var cur = dummyHead.next;
        // zero base
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) {
            addAtTail(val);
        }
        if(index < 0) {
            addAtHead(val);
        }

        var pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        var node = new MyLinkedListNode(val);
        var next = pre.next;
        pre.next = node;
        node.next = next;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of range");
        }
        var pre = dummyHead;
        for(int i = 0; i < index; i++) {
            pre = pre.next;
        }

        var needDelete = pre.next;
        pre.next = needDelete.next;
        needDelete.next = null;
        size--;
    }

}
