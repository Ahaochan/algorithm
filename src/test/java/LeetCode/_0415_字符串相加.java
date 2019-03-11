package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-strings/
 * 题目描述:
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 解题思路
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 优化思路:
 * 大数加法. 模拟加法即可.
 *
 */
public class _0415_字符串相加 {
    @Test
    public void test1() {
        Assert.assertEquals("123", addStrings("100", "23"));
        Assert.assertEquals("100", addStrings("99", "1"));
    }

    /**
     * 执行用时 : 26 ms, 在Add Strings的Java提交中击败了73.39% 的用户
     * 内存消耗 : 46.5 MB, 在Add Strings的Java提交中击败了23.27% 的用户
     */
    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] sum = new int[Math.max(len1, len2) + 1];
        int len = sum.length;

        // 1. 从 个十百千位 进行加法运算, 进位运算.
        for(int idx = len - 1, p1 = len1 - 1, p2 = len2 - 1, up = 0; idx >= 0; idx--, p1--, p2--) {
            // 1.1. 不够的位补零
            int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;

            // 1.2. 加法 并 进位
            sum[idx] = n1 + n2 + up;
            up = sum[idx] / 10;
            sum[idx] %= 10;

            // 1.3. 最高位判断是否进位
            if(p1 == 0 && p2 == 0) {
                sum[0] = up;
            }
        }

        // 2. 转为 string
        StringBuilder sb = new StringBuilder(sum.length);
        boolean findNum = false;
        for (int i = 0; i < len; i++) {
            if(!findNum) {
                if(sum[i] == 0) {
                    continue;
                } else {
                    findNum = true;
                }
            }

            sb.append(sum[i]);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
