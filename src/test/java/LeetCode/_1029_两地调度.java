package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/two-city-scheduling/
 * 题目描述:
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 * 解题思路
 */
public class _1029_两地调度 {
    @Test
    public void test1() {
        Assert.assertEquals(110, twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/24442560/
     * 执行用时 :2 ms, 在所有 Java 提交中击败了96.28%的用户
     * 内存消耗 :35.2 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int twoCitySchedCost(int[][] costs) {
        int result = 0, len = costs.length;
        int[] diff = new int[len];
        // 1. 假设所有人都去 A 市
        for (int i = 0; i < len; i++) {
            result += costs[i][0];
            diff[i] = costs[i][1] - costs[i][0];
        }

        // 2. 如果要抽出一个人, 则需要 -costs[i][0]+costs[i][1]
        //    为了达到省钱目的, result -costs[i][0]+costs[i][1] 必须要尽可能小
        //    因为 result 是常量, 所以我们只要找到 -costs[i][0]+costs[i][1] 最小的一半人数即可.
        Arrays.sort(diff);

        // 3. 将 -costs[i][0]+costs[i][1] 最小的一半人数 加入结果
        for (int i = 0, iLen = len / 2; i < iLen; i++) {
            result += diff[i];
        }
        return result;
    }
}
