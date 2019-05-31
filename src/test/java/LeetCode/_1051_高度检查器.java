package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/height-checker/
 * 题目描述:
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 *
 * 解题思路
 * 排序后和原数组做对比
 */
public class _1051_高度检查器 {
    @Test
    public void test1() {
        Assert.assertEquals(3, heightChecker(1, 1, 4, 2, 1, 3));
    }

    /**
     * 执行用时 : 3 ms, 在Height Checker的Java提交中击败了81.43% 的用户
     * 内存消耗 : 34.6 MB, 在Height Checker的Java提交中击败了100.00% 的用户
     */
    public int heightChecker(int... heights) {
        // 1. 排序后的数组
        int len = heights.length;
        int[] sorted = new int[len];
        System.arraycopy(heights, 0, sorted, 0, len);
        Arrays.sort(sorted);

        // 2. 和原数组对比
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (sorted[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
