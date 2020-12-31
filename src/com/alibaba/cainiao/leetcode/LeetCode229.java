package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode229 {

    // 记住这个做法
    // https://www.acwing.com/video/1612/
    // cur1,cur2是记录当前库存数字，curCnt1,curCnt2是库存的数字出现的次数
    public List<Integer> majorityElement(int[] nums) {
        // 定义两个候选者和它们的票数
        int cand1 = 0, cand2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int x : nums) {
            if (cnt1 > 0 && x == cand1) {
                cnt1++;
            } else if (cnt2 > 0 && x == cand2) {
                cnt2++;
            } else if (cnt1 == 0) {
                cand1 = x;
                cnt1++;
            } else if (cnt2 == 0) {
                cand2 = x;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int x : nums) {
            if (x == cand1) {
                cnt1++;
            } else if (x == cand2) {
                cnt2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (cnt1 > nums.length / 3) {
            res.add(cand1);
        }
        if (cnt2 > nums.length / 3) {
            res.add(cand2);
        }
        return res;
    }

}
