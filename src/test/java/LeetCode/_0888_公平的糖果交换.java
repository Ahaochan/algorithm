package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fair-candy-swap/
 * 题目描述:
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * 解题思路
 * A 交出 x 量的糖果, 必定会得到 y 量的糖果, 这个 y 必然存在 B 中.
 *
 * 记 A 的糖果总量为 Sa, B 的糖果总量为 Sb, 那么期望的目标糖果总量为 (Sa+Sb)/2
 * 则 A 距离目标糖果总量的表达式为 Sa - (Sa+Sb)/2, 即 (Sa-Sb)/2.
 * 此时, 假设交出去的糖果为 A[i], 那么要使 A 到达目标糖果总量, 得到的表达式
 * Sa -  x   + y   = 目标糖果总量
 * Sa - A[i] + y   = Sa - (Sa+Sb)/2
 * Sa - (A[i] - y) = Sa - (Sa+Sb)/2
 *      (A[i] - y) = (Sa+Sb)/2
 *               y = A[i] - (Sa+Sb)/2
 * 也就是说, A 交出 A[i] 量的糖果, 必须得到 A[i] - (Sa+Sb)/2 量的糖果, 才能到达目标总量
 * 只要判断 A[i] - (Sa+Sb)/2 是否存在于 B 中, 即可
 */
public class _0888_公平的糖果交换 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1,2}, fairCandySwap(new int[]{1,1}, new int[]{2,2}));
        Assert.assertArrayEquals(new int[]{1,2}, fairCandySwap(new int[]{1,2}, new int[]{2,3}));
        Assert.assertArrayEquals(new int[]{2,3}, fairCandySwap(new int[]{2}, new int[]{1,3}));
        Assert.assertArrayEquals(new int[]{5,4}, fairCandySwap(new int[]{1,2,5}, new int[]{2,4}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19737110/
     * 执行用时 : 35 ms, 在Fair Candy Swap的Java提交中击败了73.37% 的用户
     * 内存消耗 : 50.9 MB, 在Fair Candy Swap的Java提交中击败了66.09% 的用户
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        // 1. 求和 Sa 和 Sb
        int sa = 0;
        for (int value : A) {
            sa += value;
        }
        int sb = 0;
        for (int value : B) {
            sb += value;
        }

        // 2. 检查 A[i] - (Sa+Sb)/2 是否存在于 B 中
        Arrays.sort(A);
        Arrays.sort(B);
        int diff = (sa - sb) / 2; // A 距离平均值还差多少糖果
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int sub = A[i] - B[j];
            if (sub == diff) {
                int[] result = new int[2];
                result[0] = A[i];
                result[1] = B[j];
                return result;
            } else if (sub > diff) {
                j++;
            } else { // sub < diff
                i++;
            }
        }
        return null;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19737765/
     * 执行用时 : 69 ms, 在Fair Candy Swap的Java提交中击败了41.00% 的用户
     * 内存消耗 : 59.6 MB, 在Fair Candy Swap的Java提交中击败了18.69% 的用户
     */
    public int[] fairCandySwap2(int[] A, int[] B) {
        // 1. 求和 Sa 和 Sb
        int sa = 0;
        for (int value : A) {
            sa += value;
        }
        int sb = 0;
        Map<Integer, Integer> BMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            sb += B[i];
            BMap.put(B[i], i);
        }

        // 2. 检查 A[i] - (Sa+Sb)/2 是否存在于 B 中
        Arrays.sort(A);
        Arrays.sort(B);
        int diff = (sa - sb) / 2; // A 距离平均值还差多少糖果
        for (int num1 : A) {
            // 2. 检查 A[i] - (Sa+Sb)/2 是否存在于 B 中
            int num2 = num1 - diff;
            if (BMap.get(num2) != null) {
                int[] result = new int[2];
                result[0] = num1;
                result[1] = num2;
                return result;
            }
        }
        return null;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19736749/
     * 执行用时 : 178 ms, 在Fair Candy Swap的Java提交中击败了35.82% 的用户
     * 内存消耗 : 52.1 MB, 在Fair Candy Swap的Java提交中击败了56.95% 的用户
     */
    public int[] fairCandySwap1(int[] A, int[] B) {
        // 1. 求和 Sa 和 Sb
        int sa = 0;
        for (int value : A) {
            sa += value;
        }
        int sb = 0;
        for (int value : B) {
            sb += value;
        }
        int diff = (sa - sb) / 2; // A 距离平均值还差多少糖果
        for (int num1 : A) {
            // 2. 检查 A[i] - (Sa+Sb)/2 是否存在于 B 中
            int num2 = num1 - diff;
            for (int i : B) {
                if (i == num2) {
                    int[] result = new int[2];
                    result[0] = num1;
                    result[1] = num2;
                    return result;
                }
            }
        }
        return null;
    }
}
