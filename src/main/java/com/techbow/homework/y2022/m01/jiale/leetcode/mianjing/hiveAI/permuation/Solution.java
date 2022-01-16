package com.techbow.homework.y2022.m01.jiale.leetcode.mianjing.hiveAI.permuation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }

    public void permute(int[] nums, int level , List<List<Integer>> res) {
        if (level == nums.length - 1) {
            List<Integer> copy = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(copy);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            permute(nums, level + 1, res);
            swap(nums, level, i);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
