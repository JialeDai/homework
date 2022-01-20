package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC146 extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LC146(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
