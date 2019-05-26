package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/range-addition-ii/
 * 题目描述:
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 *
 * 解题思路
 * 找到最小的长和宽, 相乘即可
 */
public class _0598_范围求和II {
    @Test
    public void test1() {
        int[][] ops = {{2,2},{3,3}};
        Assert.assertEquals(4, maxCount(3, 3, ops));

    }

    @Test
    public void test2() {
        int[][] ops = {{20,10},{26,11},{2,11},{4,16},{2,3},{23,13},{7,15},{11,11},{25,13},{11,13},{13,11},{13,16},{26,17}};
        Assert.assertEquals(6, maxCount(26, 17, ops));

    }

    /**
     * https://leetcode-cn.com/submissions/detail/19531874/
     * 执行用时 : 1 ms, 在Range Addition II的Java提交中击败了98.80% 的用户
     * 内存消耗 : 37.3 MB, 在Range Addition II的Java提交中击败了84.87% 的用户
     */
    public int maxCount(int m, int n, int[][] ops) {
        for(int i = 0, len = ops.length; i < len; i++) {
            m = Math.min(m, ops[i][0]);
            n = Math.min(n, ops[i][1]);
        }
        return m * n;
    }
}
