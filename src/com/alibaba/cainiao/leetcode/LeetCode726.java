package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 726. Number of Atoms
 * Hard
 *
 *
 * Given a chemical formula (given as a string), return the count of each atom.
 *
 * An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 *
 * 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
 *
 * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
 *
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
 *
 * Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 *
 * Example 1:
 * Input:
 * formula = "H2O"
 * Output: "H2O"
 * Explanation:
 * The count of elements are {'H': 2, 'O': 1}.
 * Example 2:
 * Input:
 * formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation:
 * The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * Example 3:
 * Input:
 * formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation:
 * The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * Note:
 *
 * All atom names consist of lowercase letters, except for the first character which is uppercase.
 * The length of formula will be in the range [1, 1000].
 * formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.
 */
public class LeetCode726 {

    int i = 0;

    public String countOfAtoms(String formula) {
        int n = formula.length();
        Deque<TreeMap<String/**当前括号内的字符**/, Integer/**当前括号内单个字符个数**/>> stack = new ArrayDeque<>(n);
        TreeMap<String, Integer> curMap = new TreeMap<>();
        while (i < n) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                i++;
                stack.push(curMap);
                curMap = new TreeMap<>();
            } else if (ch == ')') {
                // 两个map合并
                TreeMap<String, Integer> temp = curMap;
                curMap = stack.pop();
                i++;
                int cnt = getNum(formula);
                for (Map.Entry<String, Integer> entry : temp.entrySet()) {
                    // "Mg(OH)2"
                    String k = entry.getKey();
                    Integer v = entry.getValue();
                    curMap.put(k, curMap.getOrDefault(k, 0) + v * cnt);
                }
            } else {
                String name = getName(formula);
                int num = getNum(formula);
                curMap.put(name, curMap.getOrDefault(name, 0) + num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : curMap.keySet()) {
            int quantity = curMap.get(name);
            sb.append(name);
            if (quantity > 1) {
                sb.append(quantity);
            }
        }
        return sb.toString();
    }

    private int getNum(String formula) {
        int n = formula.length();
        if (i == n || !(formula.charAt(i) >= '0' && formula.charAt(i) <= '9')) {
            return 1;
        }

        int cnt = 0;
        while (i < n && (formula.charAt(i) >= '0' && formula.charAt(i) <= '9')) {
            cnt = cnt * 10 + formula.charAt(i) - '0';
            i++;
        }

        return cnt;
    }

    private String getName(String formula) {
        int n = formula.length();
        // 第一个化学元素的大写字符
        StringBuilder name = new StringBuilder();
        name.append(formula.charAt(i));
        i++;

        // 余下化学元素的小写字符
        while (i < n && formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
            name.append(formula.charAt(i));
            i++;
        }
        return name.toString();
    }
}

// SimpleEntry 参考
class Pair<K, V> implements Map.Entry<K, V>, Comparable<K> {

    private K key;
    private V value;

    public Pair() {
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode())
                ^ (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;    //地址相等
        }
        if(obj == null){
            return false;   //非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }

        if (obj instanceof Map.Entry) {
            Map.Entry<? extends K, ? extends V> o = (Map.Entry<? extends K, ? extends V>) obj;
            return eq(key, o.getKey()) && eq(value, o.getValue());
        }

        return false;
    }

    private static boolean eq(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    @Override
    public int compareTo(K obj) {
        if (obj instanceof String && this.key instanceof String) {
            String k = (String) this.key;
            String o = (String) obj;
            return k.compareTo(o);
        }
        return 0;
    }
}
