package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 * 题目描述:
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 *
 * 解题思路
 * 广度优先搜索
 * 题意其实有个图更好
 * 1 1 1     1  1  1    1  1  1    1   [1] 1    1   [2] 1    [1] 2 [1]    2 2 2
 * 1 1 0  => 1 [1] 0 => 1 [2] 0 => [1]  2  0 => [2]  2  0 =>  2  2  0  => 2 2 0
 * 1 0 1     1  0  1    1  0  1    1    0  1    1    0  1    [1] 0  1     2 0 1
 *
 */
public class _0733_图像渲染 {
    @Test
    public void test1() {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] expect = {{2,2,2},{2,2,0},{2,0,1}};
        Assert.assertArrayEquals(expect, floodFill(image, 1, 1, 2));
    }

    @Test
    public void test2() {
        int[][] image = {{0,0,0},{0,0,0}};
        int[][] expect = {{2,2,2},{2,2,2}};
        Assert.assertArrayEquals(expect, floodFill(image, 0, 0, 2));
    }

    @Test
    public void test3() {
        int[][] image = {{0,0,0},{0,1,1}};
        int[][] expect = {{0,0,0},{0,1,1}};
        Assert.assertArrayEquals(expect, floodFill(image, 1, 1, 1));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/19671671/
     * 执行用时 : 5 ms, 在Flood Fill的Java提交中击败了50.59% 的用户
     * 内存消耗 : 48.2 MB, 在Flood Fill的Java提交中击败了54.86% 的用户
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 1. 记录坐标
        Stack<Integer> r = new Stack<>();
        Stack<Integer> c = new Stack<>();
        r.push(sr);
        c.push(sc);

        // 2. 如果新旧颜色一致则直接返回
        int oldColor = image[sr][sc];
        if(oldColor == newColor) {
            return image;
        }

        while (!r.isEmpty()) {
            // 3. 对当前坐标染色
            int newSr = r.pop();
            int newSc = c.pop();
            image[newSr][newSc] = newColor;

            // 4. BFS
            if(newSr - 1 >= 0 && image[newSr - 1][newSc] == oldColor) {
                r.push(newSr-1);
                c.push(newSc);
            }
            if(newSr + 1 < image.length && image[newSr + 1][newSc] == oldColor) {
                r.push(newSr+1);
                c.push(newSc);
            }
            if(newSc - 1 >= 0 && image[newSr][newSc - 1] == oldColor) {
                r.push(newSr);
                c.push(newSc - 1);
            }
            if(newSc + 1 < image[newSr].length && image[newSr][newSc + 1] == oldColor) {
                r.push(newSr);
                c.push(newSc + 1);
            }
        }
        return image;
    }
}
