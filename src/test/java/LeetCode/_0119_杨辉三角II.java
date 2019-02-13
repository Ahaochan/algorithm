package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 题目描述:
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 解题思路
 * 还是动态规划,
 * for(i=0 ... row)
 *     for(j=i ... 0)
 *         a[j] = j==0 || j==i ? 1 : a[j-1] + a[j]
 * 用O(k)的空间做, 必须从后往前遍历, 否则数据会被覆盖
 */
public class _0119_杨辉三角II {

    @Test
    public void test() {
        List<Integer> actual = getRow(3);
        int[] expect = {1,3,3,1};

        for (int i = 0; i < expect.length; i++) {
            Assert.assertEquals(expect[i], actual.get(i).intValue());
        }

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex);

        for(int i = 0; i <= rowIndex; i++) {
            result.add(0);
            for(int j = i; j >=0; j--) {
                if(j == 0 || i == j) result.set(j, 1);
                else result.set(j, result.get(j-1) + result.get(j));
            }
        }
        return result;
    }
}
