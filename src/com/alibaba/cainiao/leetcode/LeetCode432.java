package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. 全 O(1) 的数据结构
 * 请你实现一个数据结构支持以下操作：
 * <p>
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 */
public class LeetCode432 {

    Node head, tail;
    Map<String, Node> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public LeetCode432() {
        head = new Node(null, Integer.MAX_VALUE);
        tail = new Node(null, Integer.MIN_VALUE);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            Node pre = tail.pre;
            if (pre.v > 1) {
                map.put(key, insert(pre, key, 1));
            } else {
                pre.set.add(key);
                map.put(key, pre);
            }
        } else {
            Node node = map.get(key);
            node.set.remove(key);
            if (node.pre.v == node.v + 1) {
                node.pre.set.add(key);
                map.put(key, node.pre);
            } else {
                map.put(key, insert(node.pre, key, node.v + 1));
            }
            if (node.set.size() == 0) {
                delete(node);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            map.remove(key);
            if (node.next.v + 1 == node.v) {
                node.next.set.add(key);
                map.put(key, node.next);
            } else if (node.v > 1) {
                map.put(key, insert(node, key, node.v - 1));
            }
            if (node.set.size() == 0) {
                delete(node);
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.set.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (head.next == tail) return "";
        return tail.pre.set.iterator().next();
    }

    static class Node {
        int v;
        Set<String> set = new HashSet<>();
        Node pre, next;

        public Node(String key, int v) {
            this.set.add(key);
            this.v = v;
        }
    }

    Node insert(Node node, String key, int v) {
        Node p = new Node(key, v), next = node.next;
        node.next = p;
        p.pre = node;
        p.next = next;
        next.pre = p;
        return p;
    }

    void delete(Node p) {
        Node pre = p.pre, next = p.next;
        pre.next = next;
        next.pre = pre;
    }

}
