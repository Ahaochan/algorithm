package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/rotting-oranges/
 * 题目描述:
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 解题思路
 * BFS算法, 提供了队列和栈的两种实现方式
 */
public class _0994_腐烂的橘子 {
    @Test
    public void test1() {
        Assert.assertEquals(4, orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        Assert.assertEquals(-1, orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        Assert.assertEquals(0, orangesRotting(new int[][]{{0, 2}}));
        Assert.assertEquals(-1, orangesRotting(new int[][]{{1}}));
        Assert.assertEquals(0, orangesRotting(new int[][]{{0}}));
        Assert.assertEquals(1, orangesRotting(new int[][]{{1,2}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20655400/
     * 执行用时: 7 ms, 在所有Java提交中击败了 73.99% 的用户
     * 内存消耗: 37.9 MB, 在所有Java提交中击败了 81.17% 的用户
     */
    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new ArrayDeque<>();

        // 1. 统计新鲜的橘子数量, 以及将腐烂的橘子入队
        int fresh = 0;
        for (int i = 0, iLen = grid.length; i < iLen; i++) {
            for (int j = 0, jLen = grid[i].length; j < jLen; j++) {
                if(grid[i][j] == 2) {
                    queue.add((i<<4)+j);
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        // 1.1. 如果没有腐烂的橘子, 但是有新鲜的橘子, 就不会发生腐烂现象
        if(queue.size() == 0 && fresh > 0) {
            return -1;
        }
        // 1.2. 如果没有新鲜的橘子, 也不会发生腐烂现象
        if(fresh == 0) {
            return 0;
        }


        // 2. 统计上一层和本层的腐烂橘子数量
        int lastLayer = queue.size(), nowLayer = 0;
        int minute = -1;
        while (queue.size() > 0) {
            // 2.1. 腐烂橘子出队, 解码
            int point = queue.poll();
            int row = point >> 4, col = point & 0xf;

            // 2.2. 四方向判断, 有腐烂橘子则入队
            if(row-1>=0 && grid[row-1][col] == 1) {
                grid[row-1][col] = 2;
                queue.add(((row-1)<<4)+col);
                nowLayer++;
            }
            if(row+1<grid.length && grid[row+1][col] == 1) {
                grid[row+1][col] = 2;
                queue.add(((row+1)<<4)+col);
                nowLayer++;
            }
            if(col-1>=0 && grid[row][col-1] == 1) {
                grid[row][col-1] = 2;
                queue.add((row<<4)+(col-1));
                nowLayer++;
            }
            if(col+1<grid[row].length && grid[row][col+1] == 1) {
                grid[row][col+1] = 2;
                queue.add((row<<4)+(col+1));
                nowLayer++;
            }

            // 2.3. 当上一层的腐烂橘子消费完毕, 则进入下一分钟的腐烂现象
            lastLayer--;
            if(lastLayer <= 0) {
                fresh -= nowLayer;
                lastLayer = nowLayer;
                nowLayer = 0;
                minute++;
            }
        }
        // 3. 最后如果还有新鲜橘子, 则不可能被腐烂
        return fresh > 0 ? -1 : minute;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20649223/
     * 执行用时: 10 ms, 在所有Java提交中击败了 52.32% 的用户
     * 内存消耗: 34.8 MB, 在所有Java提交中击败了 98.05% 的用户
     */
    public int orangesRotting_stack(int[][] grid) {
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> first = new ArrayList<>();
        int isNotNull = 0;
        for (int i = 0, iLen = grid.length; i < iLen; i++) {
            for (int j = 0, jLen = grid[i].length; j < jLen; j++) {
                if(grid[i][j] == 2) {
                    first.add((i<<4)+j);
                }
                if(grid[i][j] != 0) {
                    isNotNull++;
                }
            }
        }
        if(first.size() == 0) {
            return isNotNull > 0 ? -1  : 0;
        }
        isNotNull -= first.size();
        stack.add(first);


        int minute = 0;
        while (stack.size() > 0) {
            List<Integer> points = stack.pop();

            List<Integer> next = new ArrayList<>();
            for (Integer point : points) {
                int row = point >> 4, col = point & 0xf;

                if(row-1>=0 && grid[row-1][col] == 1) {
                    grid[row-1][col] = 2;
                    next.add(((row-1)<<4)+col);
                }
                if(row+1<grid.length && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    next.add(((row+1)<<4)+col);
                }
                if(col-1>=0 && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    next.add((row<<4)+(col-1));
                }
                if(col+1<grid[row].length && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    next.add((row<<4)+(col+1));
                }
            }

            if(next.size() > 0) {
                isNotNull -= next.size();
                stack.push(next);
                minute++;
            }
        }


        return isNotNull > 0 ? -1 : minute;
    }


}
