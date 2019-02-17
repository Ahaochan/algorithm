package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * 题目描述:
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 解题思路
 * 26进制
 */
public class _0171_Excel表列序号 {

    @Test
    public void test() {
        Assert.assertEquals(1, titleToNumber("A"));
        Assert.assertEquals(28, titleToNumber("AB"));
        Assert.assertEquals(701, titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        int result = 0;
        for (int i = s.length() - 1, base = 1; i >= 0; i--, base *= 26) {
            result += (s.charAt(i) - 'A' + 1) * base;
        }
        return result;
    }
}
