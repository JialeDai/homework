package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 */
public class LC93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0,0, new StringBuilder(), res);
        return res;
    }

    /**
     *     three branch: {1,12, 123}
     *        three level
     * @param s
     * @param part
     * @param index
     * @param sol
     * @param res
     */
    private void dfs(String s, int part, int index, StringBuilder sol, List<String> res) {
        if (part == 4) {
            if (index == s.length()) {
                sol.setLength(sol.length()-1);
                res.add(sol.toString());
            }
            return;
        }

        int len = sol.length();
        for (int l = 1; l <= 3; l++) {
            if (index + l > s.length()) {
                break;
            }
            Integer val = Integer.valueOf(s.substring(index, index + l)); // [idx, idx+l)
            if (val >= 0 && val <= 255) {
                sol.append(val + ".");
                dfs(s, part+1, index+l, sol, res);
                sol.setLength(len);
            }
            if (val == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String input = "255834";
        System.out.println(new LC93().restoreIpAddresses(input));
    }
}
