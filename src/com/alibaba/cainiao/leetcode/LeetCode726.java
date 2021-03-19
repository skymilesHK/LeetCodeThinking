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

    private int idx = 0;

    public String countOfAtoms(String formula) {
        if (formula.length() == 0) {
            return "";
        }
        TreeMap<String, Integer> treeMap = dfs(formula);
        StringBuilder sb = new StringBuilder(formula.length());
        // 收集结果并显示打印，这个逻辑也Ok，如果数量为1，则省略
        treeMap.forEach((k, v) -> {
            sb.append(k);
            if (v > 1) {
                sb.append(v);
            }
        });

        return sb.toString();
    }

    private TreeMap<String, Integer> dfs(String s) {
        TreeMap<String, Integer> levelMap = new TreeMap<>();
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                //遇到左括号的时候，开始递归求解（）内部的串的解析结果，然后结果返回给tmp, tmp的结果和当前的结果合并
                idx++;
                TreeMap<String, Integer> tmp = dfs(s);
                int count = getCount(s);    //括号外面的次数

                // 更新levelMap,和当前的结果合并
                for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    levelMap.put(key, levelMap.getOrDefault(key, 0) + value * count);
                }
            } else if (s.charAt(idx) == ')') {
                // ')'括号退栈
                idx++;
                return levelMap;
            } else {
                // 开头不可能是数字，一定是大写字符,跳过
                String name = getName(s);
                levelMap.put(name, levelMap.getOrDefault(name, 0) + getCount(s));
            }
        }

        return levelMap;
    }

    private String getName(String s) {
        // 开头是大写数字
        StringBuilder sb = new StringBuilder(s.length());
        sb.append(s.charAt(idx++));

        while (idx < s.length() && 'a' <= s.charAt(idx) && s.charAt(idx) <= 'z') {
            sb.append(s.charAt(idx++));
        }
        return sb.toString();
    }

    //根据全局变量i，来寻找以i位置打头的数字的串，例如12
    private int getCount(String s) {
        int count = 0;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            count = count * 10 + (s.charAt(idx) - '0');
            idx++;
        }
        return count == 0 ? 1 : count;
    }
}
