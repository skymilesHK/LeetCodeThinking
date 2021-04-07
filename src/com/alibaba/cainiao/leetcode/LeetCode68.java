package com.alibaba.cainiao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * Hard
 *
 * 976
 *
 * 1939
 *
 * Add to List
 *
 * Share
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
public class LeetCode68 {
    // https://www.acwing.com/video/1406/                   讲解
    // https://www.acwing.com/solution/content/16101/       代码

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int usedLen = words[i].length();
            // j表示下一个单词
            int j = i + 1;
            while (j < words.length && usedLen + 1 + words[j].length() <= maxWidth) {
                usedLen = usedLen + 1 + words[j].length();
                j++;
            }

            // [i, j - 1] 是必须在一行的
            String line = "";
            // 如果是最后一行 或者 当前行只有一个单词，向左对齐
            if (j == words.length || j - i == 1) {
                line += words[i];
                for (int k = i + 1; k < j; k++) {
                    line += " " + words[k];
                }

                // 补足一行
                while (line.length() < maxWidth) {
                    line += " ";
                }
            }
            // 其余的左右对齐
            else {
                int gapCnt = j - i - 1;                   // 空隙数
                int rest = maxWidth - (usedLen - gapCnt); // 空格数
                //将空格数分成cnt份
                int a = rest / gapCnt ; //基本份
                int b = rest % gapCnt ; //多余份
                line += words[i];
                for (int k = i + 1; k < j; k++) {
                    if (b-- > 0) {
                        line += getBlank(a + 1) + words[k];
                    } else {
                        line += getBlank(a) + words[k];
                    }
                }
            }

            res.add(line);
            // 因为之后要i++
            i = j - 1;
        }

        return res;
    }

    private String getBlank(int x) {
        String res = "";
        for (int i = 0; i < x; i++) {
            res += " ";
        }
        return res;
    }
}
