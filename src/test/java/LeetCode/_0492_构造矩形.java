package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 题目描述:
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。
 * 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 *
 * 解题思路
 * 先求平方根, 然后找到第一个能被area整除的数即可
 */
public class _0492_构造矩形 {
    @Test
    public void test1() {
        int[] actual = constructRectangle(4);
        Assert.assertEquals(2, actual[0]);
        Assert.assertEquals(2, actual[1]);
    }

    @Test
    public void test2() {
        int[] actual = constructRectangle(2);
        Assert.assertEquals(2, actual[0]);
        Assert.assertEquals(1, actual[1]);
    }

    /**
     * 执行用时 : 1 ms, 在Construct the Rectangle的Java提交中击败了100.00% 的用户
     * 内存消耗 : 33.2 MB, 在Construct the Rectangle的Java提交中击败了0.00% 的用户
     */
    public int[] constructRectangle(int area) {
        int n = (int) Math.sqrt(area);
        while (area % n > 0 && n-- > 0) ;
        return new int[]{area / n, n};
    }
}
