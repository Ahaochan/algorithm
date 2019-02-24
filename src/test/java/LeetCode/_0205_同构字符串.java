package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * 题目描述:
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 解题思路
 * 映射表
 */
public class _0205_同构字符串 {

    @Test
    public void test1() {
        Assert.assertTrue(isIsomorphic("egg", "add"));
        Assert.assertFalse(isIsomorphic("foo", "bar"));
        Assert.assertTrue(isIsomorphic("paper", "title"));
        Assert.assertTrue(isIsomorphic("13", "42"));
        Assert.assertFalse(isIsomorphic("aba", "baa"));
    }

    public boolean isIsomorphic(String s, String t) {
        // 1. 创建两个映射表, ASCII 码只有 256 个字符
        char[] sDist = new char[256];
        char[] tDist = new char[256];

        for(int i = 0, len = s.length(); i < len; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            // 2. 如果两个映射表都没有映射, 则创建映射
            if(sDist[sc] == 0 && tDist[tc] == 0) {
                sDist[sc] = tc;
                tDist[tc] = sc;
            }
            // 3. 如果有映射, 则进行判断
            else if(sDist[sc] != tc || tDist[tc] != sc){
                return false;
            }
        }
        return true;
    }
}
