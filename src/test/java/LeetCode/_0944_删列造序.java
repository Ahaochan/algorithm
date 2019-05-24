package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted/
 * 题目描述:
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 * 选取一个删除索引序列，对于 A 中的每个字符串，删除对应每个索引处的字符。 所余下的字符串行从上往下读形成列。
 * 比如，有 A = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
 * （形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
 * 假设，我们选择了一组删除索引 D，那么在执行删除操作之后，A 中所剩余的每一列都必须是 非降序 排列的，然后请你返回 D.length 的最小可能值。
 *
 * 解题思路
 * 两个for循环, 暴力破
 */
public class _0944_删列造序 {
    @Test
    public void test1() {
        // cba
        // daf
        // ghi
        Assert.assertEquals(1, minDeletionSize("cba", "daf", "ghi"));
        Assert.assertEquals(0, minDeletionSize("a", "b"));
        // zyx
        // wvu
        // tsr
        Assert.assertEquals(3, minDeletionSize("zyx", "wvu", "tsr"));
    }

    /**
     * 执行用时 : 23 ms, 在Delete Columns to Make Sorted的Java提交中击败了78.69% 的用户
     * 内存消耗 : 47.4 MB, 在Delete Columns to Make Sorted的Java提交中击败了47.31% 的用户
     */
    public int minDeletionSize(String... A) {
        int count = 0;
        for(int col = 0, colLen = A[0].length(); col < colLen; col++) {
            for(int row = 1, rowLen = A.length; row < rowLen; row++) {
                if(A[row].charAt(col) < A[row-1].charAt(col)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
