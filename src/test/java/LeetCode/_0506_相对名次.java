package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/relative-ranks/
 * 题目描述:
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
 * 前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * (注：分数越高的选手，排名越靠前。)
 *
 * 解题思路
 * 排序算法, 用一个辅助数组记录名次
 */
public class _0506_相对名次 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}, findRelativeRanks(5, 4, 3, 2, 1));
        Assert.assertArrayEquals(new String[]{"Gold Medal","5","Bronze Medal","Silver Medal","4"}, findRelativeRanks(10, 3, 8, 9, 4));
        Assert.assertArrayEquals(new String[]{"Gold Medal","Silver Medal","4","5","Bronze Medal"}, findRelativeRanks(123123, 11921, 1, 0, 123));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25081170/
     * 执行用时 :8 ms, 在所有 Java 提交中击败了91.03%的用户
     * 内存消耗 :49.1 MB, 在所有 Java 提交中击败了76.52%的用户
     */
    public String[] findRelativeRanks(int... nums) {
        int len = nums.length;
        int[] ranks = new int[len];
        for (int i = 0; i < len; i++) {
            ranks[i] = i;
        }
        quickSort(nums, ranks, 0, len - 1);
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            switch (i) {
                case 0: result[ranks[i]] = "Gold Medal";break;
                case 1: result[ranks[i]] = "Silver Medal";break;
                case 2: result[ranks[i]] = "Bronze Medal";break;
                default:result[ranks[i]] = Integer.toString(i + 1);break;
            }
        }
        return result;
    }

    private void quickSort(int[] nums, int[] ranks, int left, int right) {
        if (left > right) return;
        int l = left;
        int r = right;
        int key = nums[left];
        while (l < r) {
            while (l < r && nums[r] <= key) r--;
            while (l < r && nums[l] >= key) l++;
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;

                temp = ranks[l];
                ranks[l] = ranks[r];
                ranks[r] = temp;
            }
        }
        nums[left] = nums[l];
        nums[l] = key;

        int temp = ranks[left];
        ranks[left] = ranks[l];
        ranks[l] = temp;

        quickSort(nums, ranks, l + 1, right);
        quickSort(nums, ranks, left, l - 1);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25077931/
     * 执行用时 :9 ms, 在所有 Java 提交中击败了86.81%的用户
     * 内存消耗 :50.7 MB, 在所有 Java 提交中击败了52.17%的用户
     */
    public String[] findRelativeRanks_dp(int... nums) {
        int len = nums.length;

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] idxArr = new int[max+1];
        for (int i = 0; i < len; i++) {
            idxArr[nums[i]] = i + 1;
        }

        String[] result = new String[len];
        for (int i = max, j = 0; i >= 0; i--) {
            if(idxArr[i] <= 0) {
                continue;
            }
            int idx = idxArr[i] - 1;
            switch (j) {
                case 0: result[idx] = "Gold Medal";break;
                case 1: result[idx] = "Silver Medal";break;
                case 2: result[idx] = "Bronze Medal";break;
                default: result[idx] = Integer.toString(j+1);
            }
            j++;
        }
        return result;
    }
}
