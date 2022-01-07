package com.techbow.homework.y2022.m01.jiale.leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 */
public class LC509 {
//    public int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return fib(n-1) + fib(n-2);
//    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < memo.length; i++) {
            memo[i] = memo[i-1]+memo[i-2];
        }
        return memo[n];
    }
}
