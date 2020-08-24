package com.alibaba.cainiao.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. Simplify Path
 * Medium
 *
 * 863
 *
 * 1858
 *
 * Add to List
 *
 * Share
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 *
 *
 *
 * Example 1:
 *
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 *
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 *
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 *
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 *
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 *
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */
public class LeetCode71 {

    // https://segmentfault.com/a/1190000003815508
    // 按照/进行split，分四种情况:
    // 遇到.和空字符串则不变 处理下一个字符
    // 遇到..时弹出一个
    // 其他字符进栈
    // 如果结果为空，要返回一个/
    // 弹出栈时要先检查栈是否为空
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        Deque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/");
        for (String str : split) {
            switch (str) {
                // 遇到.和空字符串直接进入下次循环
                case "" :
                case ".":
                    break;
                // ..出栈,进入下次循环
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(str);
                    break;
            }
        }

        // 如果结果为空，要返回一个/
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }

}
