package com.alibaba.cainiao.leetcode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setImportance(5);
        e1.setSubordinates(Arrays.asList(2, 3));

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setImportance(3);
        e2.setSubordinates(Collections.emptyList());

        Employee e3 = new Employee();
        e3.setId(3);
        e3.setImportance(3);
        e3.setSubordinates(Collections.emptyList());

        List<Employee> employees = Arrays.asList(e1, e2, e3);
        LeetCode690 leetCode = new LeetCode690();
        int importance = leetCode.getImportance(employees, 1);
        System.out.println(importance);
    }
}
