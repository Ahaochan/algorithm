package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/gray-code/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--12/
 * 题目描述:
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 *
 * 解题思路
 * 找规律 或者直接公式做
 *
 * n=0      n=1     n=2     n=3
 *  0        0      00      000
 *           1      01      001
 *                  11      011
 *                  10      010
 *                          110
 *                          111
 *                          101
 *                          100
 * 假设 G(n) 为第 n 阶格雷编码 的数字集合, G'(n) 为 G(n) 的逆序排列
 * 可以很明显看出 G(n+1) 可以经由 G(n) 推导出来
 * 1. 将 G(n) 集合中的所有数字前面加 0
 * 2. 将 G(n) 逆序排列为 G'(n)
 * 3. 将 G‘(n) 集合中的所有数字前面加 1
 */
public class _0089_格雷编码 {
    @Test
    public void test1() {
        Assert.assertEquals(Arrays.asList(0, 1, 3, 2), grayCode(2));
        Assert.assertEquals(Arrays.asList(0), grayCode(0));
    }

    /**
     * https://zh.wikipedia.org/wiki/%E6%A0%BC%E9%9B%B7%E7%A0%81#%E4%BA%8C%E9%80%B2%E4%BD%8D%E6%95%B8%E8%BD%89%E6%A0%BC%E9%9B%B7%E7%A2%BC
     * https://leetcode-cn.com/submissions/detail/25247111/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了27.12%的用户
     */
    public List<Integer> grayCode(int n) {
        List<Integer> re = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            re.add(i ^ (i >> 1));
        }
        return re;
    }
    /**
     * https://leetcode-cn.com/submissions/detail/25246077/
     * 执行用时 :3 ms, 在所有 Java 提交中击败了20.28%的用户
     * 内存消耗 :34.6 MB, 在所有 Java 提交中击败了26.88%的用户
     */
    public List<Integer> grayCode_slow(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add((1 << i) + res.get(j));
            }
        }
        return res;
    }
}
