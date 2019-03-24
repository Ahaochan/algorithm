package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/find-the-difference/
 * 题目描述:
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 解题思路
 * 利用 a ^ a = 0, 将 s 和 t 中的每个字符 异或 一遍, 即可找到多余的字符
 */
public class _0389_找不同 {
    @Test
    public void test1() {
        Assert.assertEquals('e', findTheDifference("abcd", "abcde"));
    }


    /**
     * 执行用时 : 6 ms, 在Find the Difference的Java提交中击败了80.04% 的用户
     * 内存消耗 : 35.5 MB, 在Find the Difference的Java提交中击败了0.58% 的用户
     */
    public char findTheDifference(String s, String t) {
        int merge = 0;
        for(int i = 0, len = s.length(); i < len; i++) {
            merge ^= s.charAt(i);
        }
        for(int i = 0, len = t.length(); i < len; i++) {
            merge ^= t.charAt(i);
        }
        return (char) merge;
    }
}
