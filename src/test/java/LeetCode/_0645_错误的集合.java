package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/set-mismatch/
 * 题目描述:
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 *
 * 解题思路
 * 正确的 S 集合是: 1 2 3 4 5 6 7 8  9  10  11  ... n
 * 现在的 S 集合是: 1 2 3 4 ... m-1, m, m, m+1, ... n
 *
 * 我们用 boolean[] 判断数字是否已存在, 时间复杂度为 O(n), 顺便对错误的集合求和
 *
 * 等差数列求和公式: n*1 + n*(n-1)/2
 * 那么, 丢失的数字 = 正确集合和 - 错误集合和 + 重复的数字
 */
public class _0645_错误的集合 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{2, 3}, findErrorNums(1, 2, 2, 4));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/21023763/
     * 执行用时 :5 ms, 在所有 Java 提交中击败了90.28%的用户
     * 内存消耗 :49.6 MB, 在所有 Java 提交中击败了51.90%的用户
     */
    public int[] findErrorNums(int... nums) {
        int len = nums.length;
        boolean[] exist = new boolean[nums.length];

        int duplicate = -1, sum = 0;
        for (int num : nums) {
            if (exist[num - 1]) {
                duplicate = num;
            } else {
                exist[num - 1] = true;
            }
            sum += num;
        }

        int lose = len + (len * (len - 1)) / 2 - sum + duplicate;
        return new int[] {duplicate, lose};
    }
}
