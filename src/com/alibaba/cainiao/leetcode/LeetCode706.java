package com.alibaba.cainiao.leetcode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *
 *
 * 提示：
 *
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 */
public class LeetCode706 {
    int N = 19997;
    LinkedList<Pair<Integer, Integer>>[] h = new LinkedList[N];

    /** Initialize your data structure here. */
    public LeetCode706() {
        for (int i = 0; i < N; i++) {
            h[i] = new LinkedList<>();
        }
    }

    // 从指定slot对应的链表寻找指定元素key, 取出它对应的下标
    private int indexOf(LinkedList<Pair<Integer, Integer>> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).first == key) {
                return i;
            }
        }
        return -1;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % N;
        int i = indexOf(h[hash], key);
        if (i == -1) {
            h[hash].add(new Pair<>(key, value));
        } else {
            Pair<Integer, Integer> pair = h[hash].get(i);
            pair.first = key;
            pair.second = value;
            h[hash].set(i, pair);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % N;
        int i = indexOf(h[hash], key);
        if (i == -1) {
            return -1;
        } else {
            return h[hash].get(i).second;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % N;
        int i = indexOf(h[hash], key);
        if (i == -1) {
            return;
        } else {
            h[hash].remove(i);
        }
    }

    class Pair<K extends Number, V extends Number> implements Comparable<K> {

        K first;
        V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public int compareTo(K o) {
            Integer f = (Integer) this.first;
            Integer k = (Integer) o;
            return f - k;
        }
    }
}
