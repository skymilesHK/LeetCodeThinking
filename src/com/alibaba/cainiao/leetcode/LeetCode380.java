package com.alibaba.cainiao.leetcode;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 * Medium
 *
 * Implement the RandomizedSet class:
 *
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * Follow up: Could you implement the functions of the class with each function works in average O(1) time?
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * At most 105 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 */
public class LeetCode380 {
    private Map<Integer/**数字**/, Integer/**数字下标**/> map = null;
    private List<Integer> list;
    private Random random = null;

    /** Initialize your data structure here. */
    public LeetCode380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Integer lastVal = list.get(list.size() - 1);
            // swap当前数字和list的最后一个数字，方便在list上remove当前数字时不影响其他数字index
            int idxVal = map.get(val);
            int idxLastVal = map.get(lastVal);
            list.set(idxLastVal, val);
            list.set(idxVal, lastVal);

            // swap hashmap里面数字的index
            map.put(val, idxLastVal);
            map.put(lastVal, idxVal);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
