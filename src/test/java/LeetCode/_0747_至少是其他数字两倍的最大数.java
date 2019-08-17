package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * 题目描述:
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 解题思路
 * 找出第一大的数 max1 和第二大的数 max2, 判断 max1 >= max2 * 2 即可
 */
public class _0747_至少是其他数字两倍的最大数 {
    @Test
    public void test1() {
        Assert.assertEquals(1, dominantIndex(3, 6, 1, 0));
        Assert.assertEquals(-1, dominantIndex(1, 2, 3, 4));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26240536/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.93%的用户
     * 内存消耗 :35 MB, 在所有 Java 提交中击败了88.61%的用户
     */
    public int dominantIndex(int... nums) {
        int max1 = Integer.MIN_VALUE, max2 = max1;
        int idx = -1;

        for (int i = 0, len = nums.length; i < len; i++) {
            int num = nums[i];
            if(num > max1) {
                max2 = max1;
                max1 = num;
                idx = i;
            } else if(num > max2) {
                max2 = num;
            }
        }

        return max1 >= max2 * 2 ? idx : -1;
    }
}
