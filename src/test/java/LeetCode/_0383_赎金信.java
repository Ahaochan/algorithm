package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/ransom-note/
 * 题目描述:
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * 你可以假设两个字符串均只含有小写字母。
 *
 * 解题思路
 * magazine 每个字母的数量 必定大于等于 ransom 每个字母的数量
 */
public class _0383_赎金信 {
    @Test
    public void test1() {
        Assert.assertFalse(canConstruct("a", "b"));
        Assert.assertFalse(canConstruct("aa", "ab"));
        Assert.assertTrue(canConstruct("aa", "aab"));
    }


    /**
     * 执行用时 : 19 ms, 在Ransom Note的Java提交中击败了74.08% 的用户
     * 内存消耗 : 47.3 MB, 在Ransom Note的Java提交中击败了3.42% 的用户
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letter = new int[26];
        for(int i = 0, len = magazine.length(); i < len; i++) {
            letter[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0, len = ransomNote.length(); i < len; i++) {
            int idx = ransomNote.charAt(i) - 'a';
            letter[idx]--;
            if(letter[idx] < 0) {
                return false;
            }
        }

        return true;
    }
}
