package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LC46 {
    /**
     *                                    {}
     *         level0        {1(23)}          {2(13)}                {3(12)}
     *         level1   {12(3)}  {13(2)}   {21(3)}   {23(1)}     {31(2)}   {32(1)}
     *         level2   {123}     {132}      {213}   {231}        {312}   {321}
     *
     *        number of level: input.len
     *        each level means what to choose on the current index -> for loop swap element on the index with those behind it.
     *        when to return: level 3-> level == input.length-1;
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }

    private void permute(int[] nums, int level, List<List<Integer>> res) {
        if (level == nums.length-1) {
            List<Integer> copy = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(copy);
            return;
        }

        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            permute(nums, level+1, res);
            swap(nums, level, i);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
