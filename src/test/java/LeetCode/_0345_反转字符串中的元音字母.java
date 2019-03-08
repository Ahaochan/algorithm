package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 题目描述:
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。aeiou
 *
 * 解题思路
 * 参考快速排序的代码, 双指针for
 */
public class _0345_反转字符串中的元音字母 {
    @Test
    public void test1() {
        Assert.assertEquals("Aa", reverseVowels("aA"));
        Assert.assertEquals("holle", reverseVowels("hello"));
        Assert.assertEquals("leotcede", reverseVowels("leetcode"));
    }

    /**
     * 执行用时 : 7 ms, 在Reverse Vowels of a String的Java提交中击败了74.78% 的用户
     * 内存消耗 : 40.4 MB, 在Reverse Vowels of a String的Java提交中击败了0.90% 的用户
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        for(int i = 0, j = chars.length - 1; i < j; i++, j--) {
            // 1. 从前往后找元音字母的下标
            for(char ch = chars[i]; i < j &&
                    ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch!= 'u' &&
                    ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch!= 'U';
                i++, ch = chars[i]);

            // 2. 从后往前找元音字母的下标
            for(char ch = chars[j]; i < j &&
                    ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch!= 'u' &&
                    ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch!= 'U';
                j--, ch = chars[j]);

            // 3. 如果不同则交换位置
            char ci = chars[i], cj = chars[j];
            if(i < j && ci != cj) {
                chars[j] = ci;
                chars[i] = cj;
            }
        }
        return new String(chars);
    }
}
