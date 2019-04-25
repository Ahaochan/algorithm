package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/detect-capital/
 * 题目描述:
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 *
 * 解题思路
 * 暴力统计
 */
public class _0520_检测大写字母 {


    @Test
    public void test1() {
        Assert.assertTrue(detectCapitalUse("USA"));
        Assert.assertFalse(detectCapitalUse("FlaG"));
        Assert.assertTrue(detectCapitalUse("g"));
        Assert.assertTrue(detectCapitalUse("ggg"));
    }

    /**
     * 执行用时 : 4 ms, 在Detect Capital的Java提交中击败了97.09% 的用户
     * 内存消耗 : 34.6 MB, 在Detect Capital的Java提交中击败了93.44% 的用户
     */
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 0) {
            return false;
        }
        int count = 0, len = word.length();

        // 1. 判断首字母是否大写
        char firstLetter = word.charAt(0);
        boolean isFirstUpper = 'A' <= firstLetter && firstLetter <= 'Z';
        count += (isFirstUpper ? 1 : 0);

        // 2. 统计大写字母数量
        for (int i = 1; i < len; i++) {
            char letter = word.charAt(i);
            if('A' <= letter && letter <= 'Z') {
                count++;
            }
        }

        // 3. 判断
        return count == 0 || count == len || (isFirstUpper && count == 1);
    }
}
