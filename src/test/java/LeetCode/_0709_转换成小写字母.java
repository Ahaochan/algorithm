package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/to-lower-case/
 * 题目描述:
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 * 解题思路
 * ASCII 码转换下
 */
public class _0709_转换成小写字母 {
    @Test
    public void test1() {
        Assert.assertEquals("hello", toLowerCase("Hello"));
        Assert.assertEquals("here", toLowerCase("here"));
        Assert.assertEquals("lovely", toLowerCase("LOVELY"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21025138/
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.5 MB, 在所有 Java 提交中击败了91.63%的用户
     */
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            char ch = chars[i];
            if('A' <= ch && ch <= 'Z') {
                chars[i] = (char) (ch + 32);
            }
        }
        return new String(chars);
    }
}
