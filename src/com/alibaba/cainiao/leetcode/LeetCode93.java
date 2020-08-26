package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * Medium
 *
 *
 * Given a string s containing only digits. Return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 *
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single points and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 *
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 * Example 4:
 *
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 * Example 5:
 *
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3000
 * s consists of digits only.
 */
public class LeetCode93 {

    // https://www.acwing.com/video/1438/

    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if(n > 12) {
            return res;
        }
        dfs(s, 0, 0, "");
        return res;
    }

    // k从零开始表示取到第k组数字了，k=4时说明已经取了四组数字了
    // idx是s的下标
    private void dfs(String s, int idx, int k, String path) {
        if (idx == s.length()) {
            if (k == 4) {
                // 去掉最后的.
                path = path.substring(0, path.length() - 1);
                res.add(path);
            }
            return;
        }

        if (k == 4) {
            return;
        }

        int t = 0;
        // 从idx开始搜
        for (int i = idx; i < s.length(); i++) {
            // leading 0
            if (i != idx && s.charAt(idx) == '0') {
                break;
            }

            t = t * 10 + s.charAt(i) - '0';
            if (t <= 255) {
                dfs(s, i + 1, k + 1, path + t + ".");
            } else {
                break;
            }
        }
    }

}
