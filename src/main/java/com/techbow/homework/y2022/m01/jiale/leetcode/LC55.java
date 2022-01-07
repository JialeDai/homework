package com.techbow.homework.y2022.m01.jiale.leetcode;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 *  2,3,1,1,4
 *
 *
 */
public class LC55 {
    private boolean canJump(int[] nums, int pos) {
        if (pos == nums.length-1) {
            return true;
        }
        int furthest = Math.min(pos+nums[pos], nums.length-1);
        for (int i = pos+1; i <= furthest; i++) {
            if (canJump(nums, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }
}
