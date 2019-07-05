package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * 题目描述:
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 * 解题思路
 * 对每个元素取余, 要组成能被60整除的一对歌曲, 必定有 (record[i] + record[60-i]) % 60 == 0
 * 假设每个record[i]都有对应的record[60-i], 那么组合结果必定为 record[i] * record[60-i]
 */
public class _1010_总持续时间可被60整除的歌曲 {
    @Test
    public void test1() {
        Assert.assertEquals(3, numPairsDivisibleBy60(30, 20, 150, 100, 40));
        Assert.assertEquals(3, numPairsDivisibleBy60(60, 60, 60));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22090334/
     * 执行用时 :4 ms, 在所有 Java 提交中击败了97.04%的用户
     * 内存消耗 :51.6 MB, 在所有 Java 提交中击败了42.58%的用户
     */
    public int numPairsDivisibleBy60(int... time) {
        int count = 0;
        int[] record = new int[60];
        for (int t : time) {
            record[t % 60]++;
        }

        count += (record[0] * (record[0] - 1)) >> 1;   // 特殊值, 排除掉自身, 再和自身组合, 结果要除以2
        count += (record[30] * (record[30] - 1)) >> 1; // 特殊值, 排除掉自身, 再和自身组合, 结果要除以2

        for (int i = 1; i < 30; i++) {
            count += record[i] * record[60 - i];
        }

        return count;
    }
}
