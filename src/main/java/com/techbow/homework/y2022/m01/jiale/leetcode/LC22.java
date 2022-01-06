package com.techbow.homework.y2022.m01.jiale.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 */

public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), res);
        return res;
    }


    /**
     * {}
     * (                    )          level 0
     * ((   ()               )( ))        level 1
     * ((( (() ()( ())      )() )(( ))( )))    level 2
     * <p>
     * number of levels: n
     * meaning of each level: choose left or right
     * the answer comes from the null under the leaf node.
     * pruning: left < right
     * if left > right -> add ) -> dfs(left, right+1)
     * if left = right -> add ( -> dfs(left+1, right)
     *
     * @param n
     * @param left
     * @param right
     * @param sb
     * @param res
     */
    private void dfs(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (left + right == 2 * n && left == right) {
            res.add(sb.toString());
            return;
        }

        if (right > left || left > n || right > n) {
            return;
        }

        sb.append("(");
        dfs(n, left + 1, right, sb, res);
        sb.deleteCharAt(sb.length()-1);

        sb.append(")");
        dfs(n, left, right + 1, sb, res);
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        int input = 4;
        System.out.println(new LC22().generateParenthesis(input));
    }
}
