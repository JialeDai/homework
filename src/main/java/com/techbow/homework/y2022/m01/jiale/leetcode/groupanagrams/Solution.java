package com.techbow.homework.y2022.m01.jiale.leetcode.groupanagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> record = new HashMap<>();
        for (String each : strs) {
            char[] chars =  each.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!record.containsKey(sortedStr)) {
                record.put(sortedStr, new ArrayList<>());
            }
            record.get(sortedStr).add(each);
        }
        return new ArrayList<>(record.values());
    }
}
