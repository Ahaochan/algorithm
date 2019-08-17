package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximize-distance-to-closest-person/
 * 题目描述:
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * 至少有一个空座位，且至少有一人坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 *
 * 解题思路
 * 原来以为是dp, 结果直接遍历搞定
 */
public class _0849_到最近的人的最大距离 {
    @Test
    public void test1() {
        Assert.assertEquals(2, maxDistToClosest(1, 0, 0, 0, 1, 0, 1));
        Assert.assertEquals(3, maxDistToClosest(1, 0, 0, 0));
        Assert.assertEquals(3, maxDistToClosest(0, 0, 1, 0, 0, 0));
        Assert.assertEquals(3, maxDistToClosest(0, 0, 0, 1,  0, 0));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26243934/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了89.00%的用户
     * 内存消耗 :44.2 MB, 在所有 Java 提交中击败了71.88%的用户
     */
    public int maxDistToClosest(int... seats) {
        // 1. 计算左边连续0的最大个数
        int idx = 0;
        while (seats[idx] == 0) {
            idx++;
        }

        // 2. 计算中间连续0的最大个数
        int max = idx, zero = 0;
        for (int i = idx + 1, len = seats.length; i < len; i++) {
            if(seats[i] == 0) {
                zero++;
            } else {
                max = Math.max(max, (zero + 1) / 2);
                zero = 0;
            }
        }

        // 3. 计算右边连续0的最大个数
        max = Math.max(max, zero);

        return max;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26243087/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了89.00%的用户
     * 内存消耗 :45.1 MB, 在所有 Java 提交中击败了62.50%的用户
     */
    public int maxDistToClosest_slow(int... seats) {
        // 1. 计算左边连续0的最大个数
        int zero1 = 0;
        int i = 0;
        while (seats[i] != 1) {
            zero1++;
            i++;
        }
        // 2. 计算右边连续0的最大个数
        int zero3 = 0;
        int j = seats.length - 1;
        while (seats[j] != 1) {
            zero3++;
            j--;
        }
        // 3. 计算中间连续0的最大个数
        int zero2 = 0, zeroTmp = 0;
        for (int k = i + 1; k <= j; k++) {
            if(seats[k] == 0) {
                zeroTmp++;
            } else {
                zero2 = Math.max(zero2, zeroTmp);
                zeroTmp = 0;
            }
        }

        return Math.max((zero2 + 1) / 2, Math.max(zero1, zero3));
    }
}
