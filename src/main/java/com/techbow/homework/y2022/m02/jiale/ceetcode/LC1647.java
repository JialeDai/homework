package com.techbow.homework.y2022.m02.jiale.ceetcode;

import java.util.HashSet;
import java.util.Set;

public class LC1647 {
    public int minDeletions(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0 && !set.add(freq[i])) {
                res++;
                freq[i]--;
            }
        }
        return res;
    }
}
