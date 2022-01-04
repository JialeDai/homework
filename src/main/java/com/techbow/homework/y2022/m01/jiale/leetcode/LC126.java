package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.io.StringWriter;
import java.util.*;

/**
 * word ladder II
 */
public class LC126 {
    /**
     * brute force: use word ladder I, find the shortest length. And then filter the path with min length.
     * 记录路径： x-> y using hashmap<x, y>
     * 优化：
     * 1. 能不能让所有发现的路径都是最短路径 -- bfs 看到即最短
     * 2. 废边：到不了的边，剔除没有用的搜索 (找到是a到b，现在有一条a到h)-- 反向记： to -> from -> dfs 从终点出发找出发点 （边是从start 出发做搜索去找end，从end出发反着记，一定包含start）
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     *
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> graph = new HashMap<>();
        queue.offer(beginWord);
        // if the flag is true, end after finishing this level
        boolean flag = false;
        while (!queue.isEmpty()) {
            Set<String> visitedThisLev = new HashSet<>();
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                char[] curArr = cur.toCharArray();
                for (int i = 0; i < curArr.length; i++) {
                    char temp = curArr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        curArr[i] = j;
                        String str = String.valueOf(curArr);
                        // three case;
                        if (j != temp && wordSet.contains(str)) {
                            // reach endword
                            if (str.equals(endWord)) {
                                flag = true;
                            }
                            // have not reach at the current level, build edge
                            if (!visitedThisLev.contains(str)) {
                                List<String> one = new ArrayList<>();
                                one.add(cur);
                                graph.put(str, one);
                                queue.offer(str);
                                visitedThisLev.add(str);
                            } else {
                                // build edge
                                List<String> one  = graph.get(str);
                                one.add(cur);
                                graph.put(str, one);
                            }
                        }
                    }
                    curArr[i] = temp;
                }
            }
            wordSet.removeAll(visitedThisLev);
            if (flag) {
                List<String> one = new ArrayList<>();
                one.add(endWord);
                search(res, one, endWord, beginWord, graph);
                return res;
            }
        }
        return res;
    }

    /**
     * 在某一层还原路径 recover path from graph
     * O(V+E) + O(L) L is the length of the shortest path. O(L) is the cost of the deep copy
     * @param res
     * @param one
     * @param cur
     * @param end
     * @param graph
     */
    private void search(List<List<String>> res, List<String> one, String cur, String end, Map<String, List<String>> graph) {
        if (cur.equals(end)) {
            List<String> copy = new LinkedList<>(one);
            res.add(copy);
            return;
        }
        List<String> nexts = graph.get(cur);
        for (String next: nexts) {
            one.add(0, next);
            search(res, one, next, end, graph);
            one.remove(0);
        }
    }
}
