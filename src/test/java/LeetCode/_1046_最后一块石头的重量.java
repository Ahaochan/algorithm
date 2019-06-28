package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/last-stone-weight/
 * 题目描述:
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 解题思路
 */
public class _1046_最后一块石头的重量 {
    @Test
    public void test1() {
        Assert.assertEquals(1, lastStoneWeight(1));
        Assert.assertEquals(2, lastStoneWeight(1, 3));
        Assert.assertEquals(2, lastStoneWeight(3, 7, 2));
        Assert.assertEquals(1, lastStoneWeight(2, 7, 4, 1, 8, 1));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21550195/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了79.08%的用户
     * 内存消耗 :34.6 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int lastStoneWeight(int... stones) {
        int len = stones.length;
        Arrays.sort(stones);
        while (len >= 2 && stones[len - 2] != 0) {
            stones[len - 1] -= stones[len - 2];
            stones[len - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[len - 1];
    }
}
