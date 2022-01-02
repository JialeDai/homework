package com.techbow.homework.y2022.m01.jiale.leetcode;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * two pointer: traverse the negative part in a reverse order
 */
public class LC977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int index = nums.length-1;
        while (index >= 0) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                res[index--] = (int) Math.pow(nums[left++], 2);
            } else {
                res[index--] = (int) Math.pow(nums[right--], 2);
            }
        }
        return res;
    }
}
