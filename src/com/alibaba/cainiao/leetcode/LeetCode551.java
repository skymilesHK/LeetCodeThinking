package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 551. Student Attendance Record I
 * Easy
 *
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class LeetCode551 {

    public boolean checkRecord(String s) {
        int n = s.length();
        int ACount = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                ACount++;
            }
            if (ACount > 1 || (i >= 2 && ch == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L')) {
                return false;
            }
        }

        return true;
    }

}
