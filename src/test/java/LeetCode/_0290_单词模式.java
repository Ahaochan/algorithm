package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 * 题目描述:
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 *
 * 解题思路
 * 一对一的映射, 通过两个 Map 实现
 */
public class _0290_单词模式 {

    @Test
    public void test1() {
        Assert.assertTrue(wordPattern("abba", "dog cat cat dog"));
        Assert.assertFalse(wordPattern("abba", "dog cat cat fish"));
        Assert.assertFalse(wordPattern("aaaa", "dog cat cat dog"));
        Assert.assertFalse(wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        // 0. 判断 字符数量 和 单词数量 是否相等.
        int space = 0;
        for(int i = 0, len = str.length(); i < len; i++) {
            if(str.charAt(i) == ' ') {
                space++;
            }
        }
        if(space != pattern.length() - 1) {
            return false;
        }


        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();
        for(int i = 0, iLen = pattern.length(), j = 0, jLen = str.length(); i < iLen; i++) {
            // 1. 获取 pattern 的单个字符
            char c = pattern.charAt(i);

            // 2. 获取 str 的一个单词
            StringBuilder sb = new StringBuilder();
            while (j < jLen && str.charAt(j) != ' ') {
                sb.append(str.charAt(j++));
            }
            j++;

            // 3. 判断是否冲突
            String s = sb.toString();
            String oldStr = c2s.put(c, s);
            if(oldStr != null && !s.equals(oldStr)) {
                return false;
            }
            Character oldChar = s2c.put(s, c);
            if(oldChar != null && !oldChar.equals(c)) {
                return false;
            }
        }
        return true;
    }
}
