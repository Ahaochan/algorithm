package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/deep-dark-fraction/
 * 题目描述:
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * a0 + 1/(a1 + 1/(a2 + 1/(...)))
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 * <p>
 * 解题思路
 * 数学题
 */
public class LCP_2_分式化简 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{13, 4}, fraction(3, 2, 0, 2));
        Assert.assertArrayEquals(new int[]{3, 1}, fraction(0, 0, 3));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/41811373/
     * 执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户
     * 内存消耗 : 34.7 MB , 在所有 java 提交中击败了 100.00% 的用户
     */
    public int[] fraction(int... cont) {
        int len = cont.length;
        int n = cont[len - 1], m = 1;
        for (int i = len - 2; i >= 0; i--) {
            // int tmp = n;
            // n = m;
            // m = tmp;
            //
            // n = cont[i] * m + n;

            int tmp = n;
            n = cont[i] * n + m;
            m = tmp;
        }
        return new int[]{n, m};
    }
}
