package com.techbow.homework.y2022.m02.jiale.ceetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Input: s = "a good   example"
 * Output: "example good a"
 *
 *
 * edge case: multiple space between words
 *
 *
 * idea1:
 */

public class LC151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        s.trim();
        List<String> strings = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strings);
        return String.join(",", strings);
    }
}
