package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 题目描述:
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 解题思路
 * 暴力for
 */
public class _0344_反转字符串 {
    @Test
    public void test1() {
        char[] actual = "hello".toCharArray();
        reverseString(actual);

        Assert.assertArrayEquals("olleh".toCharArray(), actual);
    }
    @Test
    public void test2() {
        char[] actual = "Hannah".toCharArray();
        reverseString(actual);

        Assert.assertArrayEquals("hannaH".toCharArray(), actual);
    }

    /**
     * 执行用时 : 16 ms, 在Reverse String的Java提交中击败了15.19% 的用户
     * 内存消耗 : 48.4 MB, 在Reverse String的Java提交中击败了0.94% 的用户
     */
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length - 1; i < j; i++, j--) {
            if(s[i] != s[j]) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }
    }
}
