package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/duplicate-zeros/
 * 题目描述:
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * 解题思路
 * 1. 双指针, 统计最多要复写多少个0
 * 2. 将最后一个0后面的数移动到末尾, dirty case Test5
 * 3. 从后往前遍历, 并位移
 * 看代码注释
 */
public class _1089_复写零 {
    @Test
    public void test1() {
        int[] array = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(array);
        Assert.assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, array);
    }

    @Test
    public void test2() {
        int[] array = {1, 2, 3};
        duplicateZeros(array);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, array);
    }

    @Test
    public void test3() {
        int[] array = {0, 0, 0, 0, 0, 0, 0};
        duplicateZeros(array);
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0}, array);
    }

    @Test
    public void test4() {
        int[] array = {0, 0, 0, 1, 0, 0, 0};
        duplicateZeros(array);
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 1}, array);
    }

    @Test
    public void test5() {
        int[] array = {8, 0, 0, 3, 7, 2, 0, 0, 1, 0, 0, 8, 0, 0};
        duplicateZeros(array);
        Assert.assertArrayEquals(new int[]{8, 0, 0, 0, 0, 3, 7, 2, 0, 0, 0, 0, 1, 0}, array);
    }

    @Test
    public void test6() {
        int[] array = {8, 4, 5, 0, 0, 0, 0, 7};
        duplicateZeros(array);
        Assert.assertArrayEquals(new int[]{8, 4, 5, 0, 0, 0, 0, 0}, array);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22597696/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了92.96%的用户
     * 内存消耗 :40.7 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public void duplicateZeros(int... arr) {
        // 1. 双指针, 统计最多要复写多少个0
        int len = arr.length;
        int zero = 0, zeroIdx = -1;
        for (int i = 0, j = len - 1; i < j; i++) {
            if (arr[i] == 0) {
                zero++;
                j--;
                zeroIdx = i;
            }
        }

        // 2. 将最后一个0后面的数移动到末尾, dirty case Test5
        int i = len - 1 - zero;
        for (; i > zeroIdx; i--) {
            arr[i + zero] = arr[i];
        }

        // 3. 从后往前遍历, 并位移
        for (; i >= 0 && zero >= 0; i--) {
            arr[i + zero] = arr[i];
            if (arr[i] == 0) {
                zero--;
                arr[i + zero] = arr[i];
            }
        }
    }
}
