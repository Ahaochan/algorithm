package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/robot-bounded-in-circle/
 * 题目描述:
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 *
 * 解题思路
 * 成环有两种情况
 * 1. 第一次指令就是一个循环
 * 2. 重复N次指令成为一个循环
 *
 * 像 GGLLGG , 就是第一种情况, 只要判断回到原点即可
 *
 * 第二种情况比较抽象, 因为成环，所以我们考虑将机器人行走的路径当做一个圆
 *        _______
 *     __|      |__
 *  __|           |__
 * |                |
 * |__            __|
 *   |__       __|
 *     |______|
 * 那么, 重复N次指令成为一个循环, 也就是每次只走 1/N 的弧.
 * 有定理, 任意一段弧, 都可构成圆.
 * 也就是说, 只要你走动了, 且方向和初始方向不同, 重复N次后, 必定可以回到原点.
 */
public class _1041_困于环中的机器人 {
    @Test
    public void test1() {
        Assert.assertTrue(isRobotBounded("GGLLGG"));
        Assert.assertFalse(isRobotBounded("GG"));
        Assert.assertTrue(isRobotBounded("GL"));
        Assert.assertTrue(isRobotBounded("GLG"));
        Assert.assertTrue(isRobotBounded("GLGRGL"));
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.63%的用户
     * 内存消耗 :33.5 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public boolean isRobotBounded(String instructions) {
        int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};

        int x = 0, y = 0, dir = 0;
        for (int i = 0, len = instructions.length(); i < len; i++) {
            switch (instructions.charAt(i)) {
                case 'G': x += DIR[dir][0]; y += DIR[dir][1]; break;
                case 'L': dir = (dir - 1 + DIR.length) % DIR.length; break;
                case 'R': dir = (dir + 1) % DIR.length; break;
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
}
