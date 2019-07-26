package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/
 * 题目描述:
 * 给出一个整数数组 A 和一个查询数组 queries。
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 * 解题思路
 */
public class _0985_查询后的偶数和 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{8, 6, 2, 4}, sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}));
        Assert.assertArrayEquals(new int[]{2, 12}, sumEvenAfterQueries(new int[]{3, 2}, new int[][]{{4, 0}, {3, 0}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23990643/
     * 执行用时 :9 ms, 在所有 Java 提交中击败了74.31%的用户
     * 内存消耗 :85.7 MB, 在所有 Java 提交中击败了6.33%的用户
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        // 1. 统计初始偶数和
        int sum = 0;
        for (int num : A) {
            if(num % 2 == 0) {
                sum += num;
            }
        }

        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            // 2. 获取操作的 val 和 index
            int val = queries[i][0], index = queries[i][1];

            // 3. 如果是奇数, 则不包括在sum里, 如果是偶数, 包括在sum里, 因为 A[index]+val 值可能为奇数, 所以先暂时减去 A[index]
            if(A[index] % 2 == 0) sum -= A[index];

            // 4. 操作数组
            A[index] += val;

            // 5. 操作后的值如果是偶数, 则加回 sum, 撤销上面的减操作.
            if(A[index] % 2 == 0) sum += A[index];

            // 6.保存值
            result[i] = sum;
        }
        return result;
    }
}
