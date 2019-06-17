package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/rectangle-overlap/
 * 题目描述:
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * 解题思路:
 * 反向排除
 * 当 [x1,x2] 和 [x3,x4] 没有交集, 则两矩形不管 y 如何取值, 都不会重叠.
 * 当 [y1,y2] 和 [y3,y4] 没有交集, 则两矩形不管 x 如何取值, 都不会重叠.
 * 排除这两种情况, 就肯定会有交集
 */
public class _0836_矩形重叠 {
    @Test
    public void test1() {
        Assert.assertTrue(isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        Assert.assertFalse(isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        Assert.assertTrue(isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20810460/
     * 执行用时 :1 ms, 在所有Java提交中击败了81.36%的用户
     * 内存消耗 :33.5 MB, 在所有Java提交中击败了93.75%的用户
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean notX = rec1[2] <= rec2[0] || rec1[0] >= rec2[2];
        if(notX) return false;
        boolean notY = rec1[3] <= rec2[1] || rec1[1] >= rec2[3];
        if(notY) return false;
        return true;
    }

    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        boolean notX = Math.max(rec1[0], rec1[2]) <= Math.min(rec2[0], rec2[2]) || Math.min(rec1[0], rec1[2]) >= Math.max(rec2[0], rec2[2]);
        if(notX) return false;
        boolean notY = Math.max(rec1[1], rec1[3]) <= Math.min(rec2[1], rec2[3]) || Math.min(rec1[1], rec1[3]) >= Math.max(rec2[1], rec2[3]);
        if(notY) return false;
        return true;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20808769/
     * 执行用时 :1 ms, 在所有Java提交中击败了81.36%的用户
     * 内存消耗 :34.1 MB, 在所有Java提交中击败了88.54%的用户
     */
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        int x11 = rec1[0], y11 = rec1[1], x12 = rec1[2], y12 = rec1[3];
        int x21 = rec2[0], y21 = rec2[1], x22 = rec2[2], y22 = rec2[3];

        boolean notX = Math.max(x11, x12) <= Math.min(x21, x22) || Math.min(x11, x12) >= Math.max(x21, x22);
        if(notX) return false;
        boolean notY = Math.max(y11, y12) <= Math.min(y21, y22) || Math.min(y11, y12) >= Math.max(y21, y22);
        if(notY) return false;
        return true;
    }
}
