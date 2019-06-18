package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-only-letters/
 * 题目描述:
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 解题思路
 * 用双指针, 参考快速排序算法
 */
public class _0917_仅仅反转字母 {
    @Test
    public void test1() {
        Assert.assertEquals("dc-ba", reverseOnlyLetters("ab-cd"));
        Assert.assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters("a-bC-dEf-ghIj"));
        Assert.assertEquals("Qedo1ct-eeLg=ntse-T!", reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        Assert.assertEquals("7_28]", reverseOnlyLetters("7_28]"));
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了71.56%的用户
     * 内存消耗 :33.7 MB, 在所有 Java 提交中击败了98.44%的用户
     */
    public String reverseOnlyLetters(String S) {

        StringBuilder sb = new StringBuilder(S);
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(sb.charAt(l))) l++;
            while (l < r && !Character.isLetter(sb.charAt(r))) r--;

            if(l < r) {
                char tmp = sb.charAt(l);
                sb.setCharAt(l++, sb.charAt(r));
                sb.setCharAt(r--, tmp);
            }
        }
        return sb.toString();
    }
}
