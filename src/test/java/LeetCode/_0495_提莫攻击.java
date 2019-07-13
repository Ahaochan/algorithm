package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/teemo-attacking/
 * 题目描述:
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 *
 * 解题思路
 * 语法题
 */
public class _0495_提莫攻击 {
    @Test
    public void test1() {
        Assert.assertEquals(4, findPoisonedDuration(new int[]{1, 4}, 2));
        Assert.assertEquals(3, findPoisonedDuration(new int[]{1, 2}, 2));
        Assert.assertEquals(0, findPoisonedDuration(new int[]{}, 10000));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22759916/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了99.59%的用户
     * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了85.80%的用户
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length <= 0) {
            return 0;
        }

        int last = timeSeries[0], p = 0;
        for (int i = 1, len = timeSeries.length; i < len; i++) {
//            p += Math.min(duration, timeSeries[i] - last);
            if(last + duration < timeSeries[i]) {
                p += duration;
            } else {
                p += (timeSeries[i] - last);
            }
            last = timeSeries[i];
        }

        return p + duration;

    }
}
