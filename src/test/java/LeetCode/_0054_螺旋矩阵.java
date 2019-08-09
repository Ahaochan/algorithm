package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 题目描述:
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 解题思路
 * 模拟题
 */
public class _0054_螺旋矩阵 {
    @Test
    public void test1() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
        Assert.assertEquals(Collections.emptyList(), spiralOrder(new int[][]{}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/25435677/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了88.00%的用户
     * 内存消耗 :35 MB, 在所有 Java 提交中击败了43.15%的用户
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();

        // 赋值上下左右边界
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;

        while(true) {
            for(int col = l; col <= r; col++) result.add(matrix[u][col]); //向右移动直到最右
            if(++u > d) break; //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
            for(int row = u; row <= d; row++) result.add(matrix[row][r]); //向下
            if(--r < l) break; //重新设定有边界
            for(int col = r; col >= l; col--) result.add(matrix[d][col]); //向左
            if(--d < u) break; //重新设定下边界
            for(int row = d; row >= u; row--) result.add(matrix[row][l]); //向上
            if(++l > r) break; //重新设定左边界
        }
        return result;
    }
}
