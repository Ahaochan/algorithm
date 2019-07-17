package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/largest-triangle-area/
 * 题目描述:
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 *
 * 解题思路
 * 套公式暴力for
 */
public class _0812_最大三角形面积 {
    @Test
    public void test1() {
        Assert.assertEquals(2, largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}), 10e-6);
        Assert.assertEquals(5.5, largestTriangleArea(new int[][]{{4, 6}, {6, 5}, {3, 1}}), 10e-6);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20029949/
     * 执行用时 : 12 ms, 在Largest Triangle Area的Java提交中击败了84.62% 的用户
     * 内存消耗 : 34.1 MB, 在Largest Triangle Area的Java提交中击败了94.85% 的用户
     */
    public double largestTriangleArea(int[][] points) {
        double maxRes = 0;
        //S =  |(x1 · y2 - x2 · y1) + (x2 · y3 - x3 · y2) + (x3 · y1 - x1 · y3)| / 2
        for (int i = 0, len = points.length; i < len; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < len; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int x1y2 = x1 * y2, x2y1 = x2 * y1;
                for (int k = j + 1; k < len; k++) {
                    int x3 = points[k][0], y3 = points[k][1];
                    int x2y3 = x2 * y3, x3y2 = x3 * y2, x3y1 = x3 * y1, x1y3 = x1 * y3;
                    maxRes = Math.max(maxRes, Math.abs(x1y2 - x2y1 - x3y2 - x1y3 + x2y3 + x3y1) / 2.0);
                }
            }
        }
        return maxRes;
    }
}
