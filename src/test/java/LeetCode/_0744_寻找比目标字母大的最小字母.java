package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * 题目描述:
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * 解题思路
 * 顺序查找, 或者二分查找
 */
public class _0744_寻找比目标字母大的最小字母 {
    @Test
    public void test1() {
        Assert.assertEquals("c", String.valueOf(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')));
        Assert.assertEquals("f", String.valueOf(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')));
        Assert.assertEquals("f", String.valueOf(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd')));
        Assert.assertEquals("j", String.valueOf(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g')));
        Assert.assertEquals("c", String.valueOf(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j')));
        Assert.assertEquals("c", String.valueOf(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k')));
        Assert.assertEquals("a", String.valueOf(nextGreatestLetter(new char[]{'a', 'b'}, 'z')));
    }

    /**
     * 执行用时 : 1 ms, 在Find Smallest Letter Greater Than Target的Java提交中击败了99.39% 的用户
     * 内存消耗 : 42.7 MB, 在Find Smallest Letter Greater Than Target的Java提交中击败了74.91% 的用户
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // (left + right) / 3
            char letter = letters[mid];
            if (letter > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < letters.length) {
            return letters[left];
        } else {
            return letters[0];
        }
    }

    /**
     * 执行用时 : 1 ms, 在Find Smallest Letter Greater Than Target的Java提交中击败了99.39% 的用户
     * 内存消耗 : 42.4 MB, 在Find Smallest Letter Greater Than Target的Java提交中击败了79.57% 的用户
     */
    public char nextGreatestLetter_for(char[] letters, char target) {
        for (int i = 0, len = letters.length; i < len; i++) {
            if(letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

}
