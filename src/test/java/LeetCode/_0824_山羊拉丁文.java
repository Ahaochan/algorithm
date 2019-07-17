package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/goat-latin/
 * 题目描述:
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 *
 * 山羊拉丁文的规则如下：
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 * 例如，单词"apple"变为"applema"。
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 *
 * 解题思路
 * 语法题
 */
public class _0824_山羊拉丁文 {
    @Test
    public void test1() {
        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", toGoatLatin("I speak Goat Latin"));
        Assert.assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa", toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21412039/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34.9 MB, 在所有 Java 提交中击败了96.53%的用户
     */
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();

        int len = S.length();
        int i = 0, a = 0;
        while (i < len) {
            // 1. 记录单词首字母
            char ch = S.charAt(i++);
            a++;

            // 2. 判断是否为元音
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                // 2.1. 元音开头字母, 则原样加入新字符串
                sb.append(ch);
                while (i < len && S.charAt(i) != ' ') {
                    sb.append(S.charAt(i++));
                }
            } else {
                // 2.2. 辅音开头字母, 则将除首字母外的字母加入新字符串, 再将首字母加入新字符串
                while (i < len && S.charAt(i) != ' ') {
                    sb.append(S.charAt(i++));
                }
                sb.append(ch);
            }

            // 3. 不管是元音还是辅音开头, 最后都会添加 ma
            sb.append("ma");
            // 4. 不管是元音还是辅音开头, 最后都会添加 a
            for (int j = 0; j < a; j++) {
                sb.append('a');
            }
            // 5. 如果不是最后一个单词, 则加入一个空格, 当前单词扫描结束
            if(++i < len) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
