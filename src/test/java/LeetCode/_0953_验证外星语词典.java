package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
 * 题目描述:
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 解题思路
 * 给出的字符串数组要按照字典序排序, 但是这个字典序不是我们的abc, 而是外星人的字典序
 */
public class _0953_验证外星语词典 {
    @Test
    public void test1() {
        Assert.assertTrue(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Assert.assertFalse(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        Assert.assertFalse(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21474827/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了75.27%的用户
     */
    public boolean isAlienSorted(String[] words, String order) {
        // 1. 记录外星人字典序的每个字母下标
        int[] dict = new int[order.length()];
        for (int i = 0, len = order.length(); i < len; i++) {
            dict[order.charAt(i) - 'a'] = i;
        }

        // 2. 两两字符串对比
        for (int i = 1, len = words.length; i < len; i++) {
            String pre = words[i - 1];
            String next = words[i];

            for (int j = 0, jLen = Math.min(pre.length(), next.length()); j < jLen; j++) {
                int preIdx = dict[pre.charAt(j) - 'a'];
                int nextIdx = dict[next.charAt(j) - 'a'];

                if(preIdx < nextIdx) {
                    break;
                } else if(preIdx > nextIdx) {
                    return false;
                }

                if(j == jLen - 1 && pre.length() > next.length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
