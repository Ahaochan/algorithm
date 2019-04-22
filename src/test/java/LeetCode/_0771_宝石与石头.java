package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * 题目描述:
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 解题思路
 * 其实就是子char查找.
 */
public class _0771_宝石与石头 {
    
    @Test
    public void test1() {
        Assert.assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
        Assert.assertEquals(0, numJewelsInStones("z", "ZZ"));
    }

    /**]
     * 执行用时 : 3 ms, 在Jewels and Stones的Java提交中击败了93.99% 的用户
     * 内存消耗 : 33.7 MB, 在Jewels and Stones的Java提交中击败了98.71% 的用户
     */
    public int numJewelsInStones(String J, String S) {
        // 1. 两个数组分别存储大小写字母的数量
        int[] lower = new int[26];
        int[] upper = new int[26];

        // 1. 先统计J中的大小写字母数量
        for (int i = 0, len = J.length(); i < len; i++) {
            char c = J.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                upper[c-'A']++;
//            } else if(c >= 'a' && c <= 'z') {
            } else {
                lower[c-'a']++;
            }
        }

        // 2. 再统计S中的大小写字母数量
        for (int i = 0, len = S.length(); i < len; i++) {
            char c = S.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                int idx = c-'A';
                upper[idx] = upper[idx] + (upper[idx] > 0 ? 1 : 0); // 注意只有J中有的字符才进行统计
//            } else if(c >= 'a' && c <= 'z') {
            } else {
                int idx = c-'a';
                lower[idx] = lower[idx] + (lower[idx] > 0 ? 1 : 0); // 注意只有J中有的字符才进行统计
            }
        }

        // 3. 去除J中的大小写字母数量
        for (int i = 0, len = J.length(); i < len; i++) {
            char c = J.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                upper[c-'A']--;
//            } else if(c >= 'a' && c <= 'z') {
            } else {
                lower[c-'a']--;
            }
        }

        // 4. 统计两个数组中的元素和
        int sum = 0;
        for (int i = 0, len = lower.length; i < len; i++) {
            sum += lower[i];
            sum += upper[i];
        }
        return sum;
    }
}
