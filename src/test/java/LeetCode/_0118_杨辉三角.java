package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 题目描述:
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 解题思路
 * 动态规划
 *
 * // 三角形的边缘都是1
 * if(i == 1 || i == j) a[i][j] = 1;
 * // 每个数是它左上方和上方的数的和
 * else a[i][j] = a[i-1][j-1] + a[i-1][j]
 */
public class _0118_杨辉三角 {

    @Test
    public void test() {
        List<List<Integer>> actual = generate(5);
        int[][] expect = {
                {1},
                {1,1},
                {1,2,1},
                {1,3,3,1},
                {1,4,6,4,1}
        };
        for(int i = 0; i < expect.length; i++) {
            for (int j = 0; j < expect[i].length; j++) {
                Assert.assertEquals(expect[i][j], actual.get(i).get(j).intValue());
            }
        }

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            for(int j = 0; j <= i; j++) {
                if(j == 0 || i == j) row.add(1);
                else row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            result.add(row);
        }
        return result;
    }
}
