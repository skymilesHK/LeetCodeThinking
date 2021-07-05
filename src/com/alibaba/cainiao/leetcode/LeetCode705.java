package com.alibaba.cainiao.leetcode;

import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例：
 *
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 *
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 *
 *
 * 提示：
 *
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains 。
 */
public class LeetCode705 {
    int N = 19997;
    LinkedList<Integer>[] h = new LinkedList[N];

    /** Initialize your data structure here. */
    public LeetCode705() {
        for (int i = 0; i < N; i++) {
            h[i] = new LinkedList<>();
        }
    }

    // 链表中命中key对应的下标
    private int indexOf(LinkedList<Integer> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    public void add(int key) {
        int hash = key % N;
        int idxOfList = indexOf(h[hash], key);
        if (idxOfList == -1) {
            h[hash].addFirst(key);
        } else {
            h[hash].set(idxOfList, key);
        }
    }

    public void remove(int key) {
        int hash = key % N;
        int idxOfList = indexOf(h[hash], key);
        if (idxOfList >= 0) {
            h[hash].remove(idxOfList);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % N;
        int idxOfList = indexOf(h[hash], key);
        return idxOfList != -1;
    }
}
