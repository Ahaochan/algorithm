package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-common-characters/
 * 题目描述:
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 解题思路
 * 看注释
 */
public class _1002_查找常用字符 {
    @Test
    public void test1() {
        List<String> expect = Arrays.asList("e", "l", "l");
        List<String> actual = commonChars("bella","label","roller");
        for (int i = 0; i < expect.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

    @Test
    public void test2() {
        List<String> expect = Arrays.asList("c","o");
        List<String> actual = commonChars("cool","lock","cook");
        for (int i = 0; i < expect.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

    @Test
    public void test3() {
        List<String> expect = Arrays.asList("c");
        List<String> actual = commonChars("caaa","cabb","cbbb");
        for (int i = 0; i < expect.size(); i++) {
            Assert.assertEquals(expect.get(i), actual.get(i));
        }
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19388762/
     * 执行用时 : 8 ms, 在Find Common Characters的Java提交中击败了83.78% 的用户
     * 内存消耗 : 37 MB, 在Find Common Characters的Java提交中击败了95.16% 的用户
     */
    public List<String> commonChars(String... A) {
        int ALen = A.length;
        char[][] letter = new char[ALen][26];

        // 1. 统计每个字符串每个字母的数量
        for (int i = 0; i < ALen; i++) {
            String string = A[i];
            for (int j = 0, jLen = string.length(); j < jLen; j++) {
                letter[i][string.charAt(j) - 'a']++;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            // 2. 统计每个字母在每行出现的最小次数, 如果不存在则为0
            int rep = Integer.MAX_VALUE;
            for (int j = 0; j < ALen; j++) {
                rep = Math.min(rep, letter[j][i]);
            }

            // 3. 加入结果集
            for (int j = 0; j < rep; j++) {
                result.add(String.valueOf(ch));
            }
        }
        return result;
    }
}
