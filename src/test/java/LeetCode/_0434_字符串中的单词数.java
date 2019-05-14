package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 * 题目描述:
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 解题思路
 */
public class _0434_字符串中的单词数 {

    @Test
    public void test1() {
        Assert.assertEquals(5, countSegments("Hello, my name is John"));
        Assert.assertEquals(4, countSegments("love live! mu'sic forever"));
    }

    /**
     * 执行用时 : 0 ms, 在Number of Segments in a String的Java提交中击败了100.00% 的用户
     * 内存消耗 : 34 MB, 在Number of Segments in a String的Java提交中击败了70.91% 的用户
     */
    public int countSegments(String s) {
        if(s == null || s.length() <= 0) {
            return 0;
        }

        int count = 0, len = s.length();
        for(int i = 1; i < len; i++) {
            // 1. 如果当前字符不是字母, 则判断前一个是否为字母, 是则+1
            if(s.charAt(i) == ' ' && s.charAt(i-1) != ' ') {
                count++;
            }
        }

        // 2. 判断最后一个字符, 如果是字母, 则+1
        if(s.charAt(len-1) != ' ') {
            count++;
        }

        return count;
    }
}
