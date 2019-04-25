package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/distribute-candies/
 * 题目描述:
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 解题思路
 * 先考虑最好的情况, 每一个糖果都是不同种类的糖果, 那么妹妹最多拿到 len / 2 种糖果.
 * 再考虑最坏的情况, 每一个糖果都是相同种类的糖果, 那么妹妹最多拿到 1 种糖果.
 *
 * 妹妹的糖果种类取值区间为 [1, len/2], 所有糖果种类取值区间为 [1, len]
 *
 * 那么只要取 两个值 [妹妹的糖果种类] 和 [所有糖果种类] 的最小值即可.
 *
 */
public class _0575_分糖果 {


    @Test
    public void test1() {
        //  一共有三种种类的糖果，每一种都有两个。
        //  最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
        Assert.assertEquals(3, distributeCandies(1,1,2,2,3,3));

        // 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
        Assert.assertEquals(2, distributeCandies(1,1,2,3));
    }

    /**
     * 执行用时 : 102 ms, 在Distribute Candies的Java提交中击败了53.35% 的用户
     * 内存消耗 : 72.6 MB, 在Distribute Candies的Java提交中击败了51.78% 的用户
     */
    public int distributeCandies_Set(int... candies) {
        // 1. 统计糖果种类
        Set<Integer> type = new HashSet<>();
        for (int candy : candies) {
            type.add(candy);
        }
        // 2. 找最小值
        return Math.min(type.size(), candies.length / 2);
    }

    /**
     * 执行用时 : 98 ms, 在Distribute Candies的Java提交中击败了61.66% 的用户
     * 内存消耗 : 74.6 MB, 在Distribute Candies的Java提交中击败了33.66% 的用户
     */
    public int distributeCandies(int... candies) {
        // 1. 先排序
        Arrays.sort(candies);

        // 2. 统计糖果种类
        int len = candies.length;
        int typeSize = 1;
        for (int i = 1; i < len; i++) {
            if(candies[i] != candies[i-1]) {
                typeSize++;
            }
        }
        // 3. 找最小值
        return Math.min(typeSize, len / 2);
    }
}
