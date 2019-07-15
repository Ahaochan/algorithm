package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/flower-planting-with-no-adjacent/
 * 题目描述:
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 *
 * 解题思路
 * 图论相关
 *
 * 用DFS超时了, 用贪心做
 */
public class _1042_不邻接植花 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{1, 2, 3}, gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}));
        Assert.assertArrayEquals(new int[]{1, 2, 1, 2}, gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, gardenNoAdj(4, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22918536/
     * 执行用时 :12 ms, 在所有 Java 提交中击败了98.37%的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int[] gardenNoAdj(int N, int[][] paths) {
        // 1. 因为只有4种花, 所以要做到不邻接植花, 就最多只能有3个花园能和当前花园邻接
        int[][] map = new int[N+1][3]; // map[i][j] = k 表示 花园i 邻接的 第j个花园 是 花园k

        // 2. 初始化邻接路径
        for (int[] path : paths) {
            int x = path[0], y = path[1];

            int idx = 0;
            while (map[x][idx] != 0) idx++;
            map[x][idx] = y;

            idx = 0;
            while (map[y][idx] != 0) idx++;
            map[y][idx] = x;
        }

        // 3. 遍历每个花园
        int[] flowers = new int[N+1];
        for (int i = 1; i <= N; i++) {
            // 3.1. 尝试种花, 查看当前花园的邻接花园, 是否有相同的花
            for (int flower = 1; flower <= 4; flower++) {
                if(flowers[map[i][0]] != flower
                        && flowers[map[i][1]] != flower
                        && flowers[map[i][2]] != flower) {
                    flowers[i] = flower;
                    break;
                }
            }
        }

        // 4. 清掉第一个0
        int[] result = new int[N];
        System.arraycopy(flowers, 1, result, 0, N);
        return result;
    }
}
