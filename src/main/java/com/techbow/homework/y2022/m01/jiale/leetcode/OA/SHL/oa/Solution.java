package com.techbow.homework.y2022.m01.jiale.leetcode.OA.SHL.oa;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * countTown, representing the number of times each town can be chosen.
 */
public class Solution {
    public static int maxDaysToWork(int[] countTown) {
        int answer = 0;
        // Write your code here
        int last = -1;
        int zeros = getZeros(countTown);
        while (zeros < countTown.length - 1) {
            int max = -1;
            for (int i = 0; i < countTown.length; i++) {
                if (i == last || countTown[i] == 0) {
                    continue;
                }
                if (countTown[i] > max) {
                    max = Math.max(max, countTown[i]);
                    last = i;
                }
            }
            countTown[last]--;
            Arrays.stream(countTown).forEach(System.out::print);
            System.out.println();
            if (countTown[last] == 0) {
                zeros++;
            }
            answer++;
        }
        return answer+1;
    }

    private static int getZeros(int[] arr) {
        int count = 0;
        for (int each : arr) {
            if (each == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int countTown[] = {2,2,2,2};

        int result = maxDaysToWork(countTown);
        System.out.print(result);

    }
}

