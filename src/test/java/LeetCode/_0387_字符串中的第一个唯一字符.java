package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 题目描述:
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 解题思路
 * 记录每个字母出现的次数, 再遍历字符串找出出现次数为1的字母
 *
 */
public class _0387_字符串中的第一个唯一字符 {
    @Test
    public void test1() {
        Assert.assertEquals(0, firstUniqChar("leetcode"));
        Assert.assertEquals(2, firstUniqChar("loveleetcode"));
    }

    /**
     * 执行用时 : 21 ms, 在First Unique Character in a String的Java提交中击败了78.07% 的用户
     * 内存消耗 : 37 MB, 在First Unique Character in a String的Java提交中击败了31.28% 的用户
     */
    public int firstUniqChar(String s) {
        int len = s.length();
        int[] letter = new int[26];
        // 1. 记录每个字母出现的次数
        for(int i = 0; i < len; i++) {
            letter[s.charAt(i) - 'a']++;
        }
        // 2. 再遍历字符串找出出现次数为1的字母
        for(int i = 0; i < len; i++) {
            if(letter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
