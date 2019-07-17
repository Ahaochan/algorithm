package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/rotate-string/
 * 题目描述:
 * 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。
 * 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 解题思路
 */
public class _0796_旋转字符串 {
    @Test
    public void test1() {
        Assert.assertTrue(rotateString("abcde", "cdeab"));
        Assert.assertFalse(rotateString("abcde", "abced"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20107241/
     * 执行用时 : 1 ms, 在Rotate String的Java提交中击败了97.66% 的用户
     * 内存消耗 : 33.2 MB, 在Rotate String的Java提交中击败了97.40% 的用户
     */
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A+A).contains(B);
    }
}
