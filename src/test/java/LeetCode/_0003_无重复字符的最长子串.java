package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 题目描述:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * abcabcbb 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * bbbbb 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * pwwkew 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 * 解题思路
 * 滑动窗口的算法
 * 有两个标志位 i, j, 意味着 s[i]-s[j] 内没有重复的字符.
 * 每次都 j++, 扩展不重复子串的长度.
 * 当遇到在 s[i]-s[j] 内重复的字符 s[k] 时, 收缩i (i++), 直到 i = k+1.
 */
public class _0003_无重复字符的最长子串 {

    @Test
    public void test() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(1, lengthOfLongestSubstring(" "));
        Assert.assertEquals(3, lengthOfLongestSubstring("dvdf"));
        Assert.assertEquals(2, lengthOfLongestSubstring("au"));
        Assert.assertEquals(2, lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        // 1. 声明两个边界i,j, 每次都 j++, 扩展不重复子串的长度.
        for(int i = 0, j = 0, slen = s.length(); j < slen; j++) {
            char ch = s.charAt(j);

            // 4. 如果有重复, 则 收缩i (i++), 直到 i = k+1, 这里使用 max() 是因为 i 不允许回弹到比 i 小的位置, 比如 "abba" 的测试用例
            if(map.containsKey(ch)) {
                i = Math.max(map.get(ch) + 1, i);
            }

            // 2. 将两个边界i,j的长度存起来
            len = Math.max(len, j - i + 1);
            // 3. 缓存或更新 s[j] 的位置
            map.put(ch, j);
        }
        return len;
    }
}
