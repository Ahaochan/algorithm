package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 * 题目描述:
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。
 * 但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，
 * 我们可以将这个饼干 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 *
 * 解题思路
 * 先排序, 然后贪心算法
 *
 */
public class _0455_分发饼干 {
    @Test
    public void test1() {
        Assert.assertEquals(1, findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        Assert.assertEquals(2, findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }

    /**
     * 执行用时 : 21 ms, 在Assign Cookies的Java提交中击败了62.13% 的用户
     * 内存消耗 : 48.7 MB, 在Assign Cookies的Java提交中击败了0.94% 的用户
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int i = 0, j = 0, gLen = g.length, sLen = s.length; i < gLen && j < sLen; j++) {
            if(g[i] <= s[j]) {
                count++;
                i++;
            }

        }
        return count;
    }
}
