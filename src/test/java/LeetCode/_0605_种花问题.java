package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 * 题目描述:
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 解题思路
 * 暴力遍历
 */
public class _0605_种花问题 {

    @Test
    public void test() {
        Assert.assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        Assert.assertFalse(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        Assert.assertFalse(canPlaceFlowers(new int[]{1, 0}, 1));
        Assert.assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
        Assert.assertTrue(canPlaceFlowers(new int[]{0}, 1));
    }

    /**
     * 执行用时 : 13 ms, 在Can Place Flowers的Java提交中击败了45.34% 的用户
     * 内存消耗 : 48.9 MB, 在Can Place Flowers的Java提交中击败了0.00% 的用户
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0, len = flowerbed.length; i < len && n > 0; i++) {
            boolean pre = i - 1 >= 0 && flowerbed[i - 1] == 1;
            boolean next = i + 1 < len && flowerbed[i + 1] == 1;
            if(flowerbed[i] == 0 && !pre && !next) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }
}
