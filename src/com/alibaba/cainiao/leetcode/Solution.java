package com.alibaba.cainiao.leetcode;

import java.util.*;
import java.awt.Point;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    // 看视频1:23秒讲解领接表 https://www.acwing.com/video/21/
    public static void main(String[] args) {
        // creating tree map
        TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();

        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
//        treemap.put(6, "six");
        treemap.put(5, "five");

        System.out.println("Checking floor entry for 6");
        System.out.println("Value is: "+ treemap.floorEntry(6));


    }

    // https://www.acwing.com/solution/content/526/
    public int scheduleCourse(int[][] courses) {
        //根据课程结束时间升序排列
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        //课程用时的大根优先级队列
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int times = 0;
        for (int i = 0; i < courses.length; i++) {
            //如果此课程可以学习，则学习，总用时增加，此课程用时入堆
            queue.add(courses[i][0]);
            if (times + courses[i][0] <= courses[i][1]) {
                times += courses[i][0];
            } else {
                //如果不能学习此课程，因为此课程结束时间比之前所有的都晚，存在两种情况：
                //1.此课程用时比之前某个课程少：则学习此课程，放弃之前用时最长的课程
                //2.此课程用时比之前所有课程多：则不学习此课程，可以理解为学习此课程，同时放弃之前用时最长的课程（此课程）
                //则此种情况，学习此课程并放弃之前用时最长的课程（总用时减去大根堆堆顶）
                times = times + courses[i][0] - queue.poll();
            }
        }
        return queue.size();
    }
}

class Trie {

    public class TrieNode {
        public boolean isWord;
        public TrieNode[] next;

        public TrieNode() {
            isWord = false;
            next = new TrieNode[26];
        }
    }

    TrieNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new TrieNode();
            }
            cur = cur.next[idx];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                return false;
            }
            cur = cur.next[idx];
        }

        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                return false;
            }
            cur = cur.next[idx];
        }
        return true;
    }

}
