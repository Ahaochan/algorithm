package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/baseball-game/
 * 题目描述:
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 *
 * 解题思路
 * 模拟运算即可
 */
public class _0682_棒球比赛 {
    @Test
    public void test1() {
        Assert.assertEquals(30, calPoints("5","2","C","D","+"));
        Assert.assertEquals(27, calPoints("5", "-2", "4", "C", "D", "9", "+", "+"));
    }

    /**
     * 执行用时 : 7 ms, 在Baseball Game的Java提交中击败了81.38% 的用户
     * 内存消耗 : 38 MB, 在Baseball Game的Java提交中击败了0.87% 的用户
     */
    public int calPoints(String... ops) {
        int len = ops.length;
        int[] arr = new int[len];
        for(int i = 0, j = 0; i < len; i++) {
            String op = ops[i];
            switch (op) {
                case "+": arr[j] = arr[j-1] + arr[j-2]; j++; break;
                case "D": arr[j] = 2*arr[j-1]; j++; break;
                case "C": arr[j-1] = 0; j--; break;
                default: arr[j] = Integer.parseInt(op); j++;
            }
        }
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
