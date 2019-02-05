package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 * 题目描述:
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 解题思路
 * 从后往前计数, 碰到空格停止
 * 记得trim, 题目要求
 */
public class _0053_最后一个单词的长度 {
    @Test
    public void test() {
        Assert.assertEquals(5, lengthOfLastWord("Hello world"));
        Assert.assertEquals(1, lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        for(int i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; i--) {
            count++;
        }
        return count;
    }
}
