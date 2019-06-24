package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/keyboard-row/
 * 题目描述:
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 解题思路
 * 语法题
 */
public class _0500_键盘行 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new String[]{"Alaska", "Dad"}, findWords("Hello", "Alaska", "Dad", "Peace"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21264068/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.07%的用户
     * 内存消耗 :34.8 MB, 在所有 Java 提交中击败了80.81%的用户
     */
    public String[] findWords(String... words) {
        String[] lines = {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        List<String> result = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();

            // 1. 确定第一个字符在哪一行
            String find = null;
            for (String line : lines) {
                if(line.indexOf(chars[0]) > -1) {
                    find = line;
                    break;
                }
            }
            if(find == null) {
                continue;
            }

            // 2. 判断后续字符是否在同一行
            boolean flag = true;
            for (char ch : chars) {
                if(find.indexOf(ch) < 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
