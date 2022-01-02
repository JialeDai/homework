package com.techbow.homework.y2022.m01.jiale.leetcode;

/**
 * rotate array
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class LC189 {
    /**
     * 1. brute force - we rotate the array by 1 and repeat k times. (time limit exceed)
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k %= nums.length;
        int tmp, prev;
        for (int i = 0; i <k; i++) {
            prev = nums[nums.length-1];
            for (int j = 0; j<nums.length;j++) {
                tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
        }
    }

    /**
     * 2. use a extra array
     * We use an extra array in which we place every element of the array at its correct position
     * i.e. the number at index ii in the original array is placed at the index (i + k) \% \text{ length of array}(i+k)% length of array.
     * Then, we copy the new array to the original one.
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int[] arr = new int[nums.length];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            arr[(i+k)%len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = arr[i];
        }
    }
}
