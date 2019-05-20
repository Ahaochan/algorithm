package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/most-common-word/
 * 题目描述:
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 * 解题思路
 * 面向API编程
 * 优化的地方挺多的, 但都是重复造轮子
 */
public class _0819_最常见的单词 {

    @Test
    public void test1() {
        Assert.assertEquals("ball", mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", "hit"));
        Assert.assertEquals("a", mostCommonWord("a."));
        Assert.assertEquals("ball", mostCommonWord("Bob. hIt, baLl", "bob", "hit"));
        Assert.assertEquals("b", mostCommonWord("a, a, a, a, b,b,b,c, c", "a"));
    }

    /**
     * 执行用时 : 90 ms, 在Most Common Word的Java提交中击败了13.41% 的用户
     * 内存消耗 : 38.6 MB, 在Most Common Word的Java提交中击败了65.77% 的用户
     */
    public String mostCommonWord(String paragraph, String... banned) {
        // 1. 转换小写
        paragraph = paragraph.toLowerCase();
        for (int i = 0, len = banned.length; i < len; i++) {
            banned[i] = banned[i].toLowerCase();
        }

        // 2. 去除标点符号
        paragraph = paragraph.replaceAll("[!?',;.]", " ");

        // 3. 统计单词数量
        String[] split = paragraph.split(" ");
        Map<String, Integer> count = new HashMap<>();
        for (String s : split) {
            if(!"".equals(s)) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }
        }

        // 4. 按单词数排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort(Map.Entry.comparingByValue());

        // 5. 逆序找到第一个不在黑名单中的单词
        for (int i = list.size() - 1; i >= 0 ; i--) {
            Map.Entry<String, Integer> entry = list.get(i);
            String key = entry.getKey();
            if(!contains(banned, key)) {
                return key;
            }
        }
        return "";
    }

    private boolean contains(String[] array, String search) {
        if(array == null || array.length <= 0) {
            return false;
        }
        for (String item : array) {
            if(item.equals(search)) {
                return true;
            }
        }
        return false;
    }
}
