package com.techbow.homework.y2021.m12.jiale.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * word ladder
 * vertex word;
 * neighbour: all the words with one character differnece.
 */
public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // cc
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int minLen = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                String cur = queue.poll();
                List<String> neighbours = getNeighbours(cur, wordList);
                for (String each : neighbours) {
                    if (each.equals(endWord)) {
                        return minLen;
                    }
                    wordList.remove(each);
                    queue.offer(each);
                }
            }
            minLen ++;
        }
        return 0;
    }

    private List<String> getNeighbours(String cur, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String each : wordList) {
            if (getDifference(cur, each) == 1) {
                res.add(each);
            }
        }
        return res;
    }

    private int getDifference(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return -1;
        }
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
