package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * 题目描述:
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 解题思路
 * 26进制
 *
 */
public class _0168_Excel表列名称 {

    @Test
    public void test() {
        Assert.assertEquals("A", convertToTitle(1));
        Assert.assertEquals("Z", convertToTitle(26));
        Assert.assertEquals("AA", convertToTitle(27));
        Assert.assertEquals("AB", convertToTitle(28));
        Assert.assertEquals("ZY", convertToTitle(701));
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            int mod = n % 26;
            n /= 26;

            // 处理当 mod = 0 的情况
            if(mod == 0) {
                mod = 26;
                n -= 1;
            }

            sb.append((char) ('A' - 1 + mod));
        }
        return sb.reverse().toString();
    }
}
