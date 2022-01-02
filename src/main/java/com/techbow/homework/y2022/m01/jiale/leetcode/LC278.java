package com.techbow.homework.y2022.m01.jiale.leetcode;

/**
 * First Bad Version
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 * we do a binary search on 1 to n version. when mid is a bad version, we do not know if it is the first bad version, so we always look in the right part of the array. if the mid version is not the bed verion, we move to the right part.
 */
public class LC278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid  = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }
        if (isBadVersion(right)) {
            return right;
        }
        return -1;
    }

    private boolean isBadVersion(int n) {
        return false; // placeholder
    }
}
