package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/minimum-time-visiting-all-points/
 * 题目描述:
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
 * 你可以按照下面的规则在平面上移动：
 * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 *
 * 解题思路
 * 取两点x、y的差值最大值, 即为移动的时间
 */
public class _1266_访问所有点的最小时间 {
    @Test
    public void test1() {
        Assert.assertEquals(7, minTimeToVisitAllPoints(new int[][]{{1,1},{3,4},{-1,0}}));
        Assert.assertEquals(5, minTimeToVisitAllPoints(new int[][]{{3,2},{-2,2}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/41992812/
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :42.2 MB, 在所有 java 提交中击败了100.00%的用户
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int sec = 0;

        for (int i = 0, len = points.length - 1; i < len; i++) {
            sec += Math.max(Math.abs(points[i+1][0]-points[i][0]),
                    Math.abs(points[i+1][1]-points[i][1]));
        }
        return sec;
    }
}
