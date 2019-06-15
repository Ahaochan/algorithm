package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/valid-boomerang/
 * 题目描述:
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 *
 * 解题思路
 * 求斜率, 数学题
 */
public class _1037_有效的回旋镖 {
    @Test
    public void test1() {
        Assert.assertTrue(isBoomerang(new int[][]{{1,1},{2,3},{3,2}}));
        Assert.assertFalse(isBoomerang(new int[][]{{1,1},{2,2},{3,3}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20701814/
     * 执行用时 :1 ms, 在所有Java提交中击败了99.74%的用户
     * 内存消耗 :34.1 MB, 在所有Java提交中击败了100.00%的用户
     */
    public boolean isBoomerang(int[][] points) {
        double k12 = (points[0][1] - points[1][1]) * 1.0 / (points[0][0]-points[1][0]);
        double k13 = (points[0][1] - points[2][1]) * 1.0 / (points[0][0]-points[2][0]);
        return Math.abs(k12 - k13) > 10e-6;
    }
}
