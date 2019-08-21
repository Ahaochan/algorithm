package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 题目描述:
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 解题思路
 */
public class _0287_寻找重复数 {
    @Test
    public void test1() {
        Assert.assertEquals(2, findDuplicate(1, 3, 4, 2, 2));
        Assert.assertEquals(3, findDuplicate(3, 1, 3, 4, 2));
        Assert.assertEquals(6, findDuplicate(1, 4, 6, 6, 6, 2, 3));
        Assert.assertEquals(9, findDuplicate(2, 5, 9, 6, 9, 3, 8, 9, 7, 1));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/26754301/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.88%的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了29.64%的用户
     */
    public int findDuplicate(int... nums) {
        // 1. 找到快慢指针相遇的点
        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 2. 用一个新指针, 找到和慢指针相遇的点
        int find = 0;
        while (find != slow) {
            slow = nums[slow];
            find = nums[find];
        }

        return find;
    }
}
