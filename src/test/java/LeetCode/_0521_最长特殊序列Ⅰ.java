package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 题目描述:
 * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 *
 * 解题思路
 * 语文题, 实际上就是比较两个 不同 字符串的最大长度
 */
public class _0521_最长特殊序列Ⅰ {
    @Test
    public void test1() {
        Assert.assertEquals(3, findLUSlength("aba", "cdc"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/28156341/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了59.56%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了62.07%的用户
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
