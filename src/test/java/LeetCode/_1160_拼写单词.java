package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 * 题目描述:
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * 解题思路
 */
public class _1160_拼写单词 {
    @Test
    public void test1() {
        Assert.assertEquals(6, countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        Assert.assertEquals(10, countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/28447651/
     * 执行用时 :9 ms, 在所有 Java 提交中击败了97.75%的用户
     * 内存消耗 :48.9 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int countCharacters(String[] words, String chars) {
        // 1. 统计可用单词数量
        int[] counts = new int[26];
        for (int i = chars.length() - 1; i >= 0; i--) {
            counts[chars.charAt(i) - 'a']++;
        }

        int result = 0;
        for (String word : words) {
            // 2. 备份可用单词数量
            int[] countsCopy = Arrays.copyOf(counts, counts.length);

            // 3. 判断是否足够 word 消耗
            boolean success = true;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if(--countsCopy[idx] < 0) {
                    success = false;
                    break;
                }
            }

            // 4. 足够则加入
            if(success) {
                result += word.length();
            }
        }
        return result;
    }
}
