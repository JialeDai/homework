package com.techbow.homework.y2022.m02.jiale.ceetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * <p>
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * <p>
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 * <p>
 * <p>
 * 思路：
 * - 尽可能悠闲使用当前数量最多的字母， 因为最后同一种字母剩余最多越容易出现字母连续相同的情况。如果构建完成醉成的快乐字符串后还存在剩余为选择的字母，则剩余的字母一点为同一种字母，切该字母东总数量最多
 * - 依次从当前最多的字母开始尝试，如果发现加入当前字母会导致出现3个连续的字母，则跳过当前字母， 直到我们找到可以添加的字母为止。
 * - 如果吃昂是所有的字母都无法添加，则直接退出，此时构成的字符串为最长的快乐字符串
 */
public class LC1405 {
    class Pair {
        public char ch;
        public int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        Pair[] arr = new Pair[]{new Pair('a', a), new Pair('b', b), new Pair('c', c)};

        while (true) {
            Arrays.sort(arr, (p1, p2) -> p2.count - p1.count);
            boolean hasNext = false;
            for (Pair each : arr) {
                if (each.count <= 0) {
                    break;
                }
                int m = res.length();
                if (m >= 2 && res.charAt(m - 2) == each.ch && res.charAt(m - 1) == each.ch) {
                    continue;
                }
                res.append(each.ch);
                each.count--;
                hasNext = true;
                break;
            }
            if (!hasNext) {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LC1405().longestDiverseString(1, 1, 7));
    }
}
