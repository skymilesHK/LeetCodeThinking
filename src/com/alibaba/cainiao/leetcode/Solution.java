package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

    // https://www.youtube.com/watch?v=Jth8IeLR6Os  动画
    // https://www.acwing.com/video/1518/  代码

    int capacity = 0;
    int size = 0;
    Map<Integer, DNode> map = null;
    /**
     * 虚拟头结点没有前驱
     */
    private DNode head;
    /**
     * 虚拟尾结点没有后继
     */
    private DNode tail;


    public Solution(int capacity) {
        head = new DNode(0, 0);
        tail = new DNode(0, 0);

        head.right = tail;
        tail.left = head;
        size = 0;
        this.capacity = capacity;
    }

    /**
     * 如果哈希表的容量满了，就要删除一个链表末尾元素，然后在链表头部插入新元素
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
            add2Head(key, value);
        } else {
            add2Head(key, value);
        }
    }

    /**
     * 如果存在，把当前结点移动到双向链表的头部
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        DNode node = map.get(key);
        // 把当前 node 原地删除 再加动到双向链表的头部
        remove(key);
        add2Head(key, node.value);
        return node.value;
    }

    /**
     * 双链表队头加入一个点，包括map
     * @param key
     * @param value
     */
    private void add2Head(int key, int value) {
        DNode newNode = new DNode(key, value);
        DNode h = head.right;
        newNode.right = h;
        h.left = newNode;
        head.right = newNode;
        newNode.left = head;

        size++;
        map.put(key, newNode);
        if (size > capacity) {
            remove(tail.left.key);
        }
    }

    /**
     * 双链表删除一个点,map也删除
     * @param key
     */
    private void remove(int key) {
        DNode node = map.get(key);
        if (node == null) {
            return;
        }
        map.remove(key);
        size--;
        DNode prev = node.left;
        DNode next = node.right;
        prev.right = next;
        next.left = prev;

        node.left = null;
        node.right = null;
    }

    /**
     * 双链表结点类
     */
    class DNode {
        int key = 0;
        int value = 0;
        DNode left = null;
        DNode right = null;

        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}