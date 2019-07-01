package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/card-flipping-game/
 * 题目描述:
 * 在桌子上有 N 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
 * 我们可以先翻转任意张卡片，然后选择其中一张卡片。
 * 如果选中的那张卡片背面的数字 X 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
 * 哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0。
 * 其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。
 * 如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。
 *
 * 解题思路
 */
public class _0822_翻转卡片游戏 {
    
    @Test
    public void test1() {
//        Assert.assertEquals(2, flipgame(new int[]{1,2,4,4,7}, new int[]{1,3,4,1,3}));
//        Assert.assertEquals(10, flipgame(new int[]{5,7,6,2,3,4,4,2,1,3}, new int[]{5,7,4,6,3,3,4,2,1,10}));
        Assert.assertEquals(2, flipgame(new int[]{1,1}, new int[]{2,1}));
    }

    public int flipgame(int[] fronts, int[] backs) {
        if(fronts == null || backs == null || fronts.length != backs.length) {
            return 0;
        }

        int[] dump = new int[2000];
        for (int i = 0, len = fronts.length; i < len; i++) {
            dump[fronts[i]]++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0, len = backs.length; i < len; i++) {
            if(dump[backs[i]] == 0) {
                min = Math.min(min, i);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min + 1;
    }
}
