package com.alibaba.cainiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 87. 扰乱字符串
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 * 示例 2：
 *
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 * 示例 3：
 *
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 *
 *
 * 提示：
 *
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 和 s2 由小写英文字母组成
 */
public class LeetCode87 {
    // https://v.youku.com/v_show/id_XMzg5MzI3NjUwNA==.html?spm=a2h0k.11417342.soresults.dtitle

    public Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        String s = s1 + s2;
        if(memo.containsKey(s)){
            return memo.get(s);
        }

        if (s1.equals(s2)) {
            return true;
        }

        int n1 = s1.length();
        int n2 = s2.length();
        int letters[] = new int[26];
        for (int i = 0; i < n1; ++i) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        // 去判断两个字符串包含的字符个数一样
        for (Integer letter : letters) {
            if (letter != 0) {
                return false;
            }
        }

        // 如何切分s1或者s2, 只要有一种方式符合scrambled，就返回true
        for (int index = 1; index < n1; ++index) {
            // 1. s1左子树 scrambled s2左子树 && s1右子树 scrambled s2右子树
            if (isScramble(s1.substring(0, index), s2.substring(0, index)) && isScramble(s1.substring(index), s2.substring(index))) {
                memo.put(s, true);
                return true;
            }
            // 2.s1左子树 scrambled s2右子树 && s1右子树 scrambled s2左子树
            if (isScramble(s1.substring(0, index), s2.substring(n2 - index)) && isScramble(s1.substring(index), s2.substring(0, n2 - index))) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
