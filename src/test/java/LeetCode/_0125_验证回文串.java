package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/comments/
 * 题目描述:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 解题思路
 * head tail 两个指针往中间走
 */
public class _0125_验证回文串 {

    @Test
    public void test() {
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j;) {
            char head = s.charAt(i), tail = s.charAt(j);
            if(!Character.isLetterOrDigit(head)) {
                i++;
            } else if(!Character.isLetterOrDigit(tail)) {
                j--;
            } else if (Character.toLowerCase(head) == Character.toLowerCase(tail)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
