package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * 题目描述:
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 解题思路
 * 排序, 取最大的 a+b>c 的组合
 *
 */
public class _0976_三角形的最大周长 {
    @Test
    public void test1() {
        Assert.assertEquals(5, largestPerimeter(2, 1, 2));
        Assert.assertEquals(0, largestPerimeter(1, 2, 1));
        Assert.assertEquals(10, largestPerimeter(3, 2, 3, 4));
        Assert.assertEquals(8, largestPerimeter(3, 2, 6, 3));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/29220477/
     * 执行用时 :22 ms, 在所有 Java 提交中击败了79.50%的用户
     * 内存消耗 :49.4 MB, 在所有 Java 提交中击败了34.66%的用户
     */
    public int largestPerimeter(int... A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; i--) {
            if(A[i] + A[i + 1] > A[i+2]) {
                return A[i] + A[i + 1] + A[i+2];
            }
        }
        return 0;
    }
}
