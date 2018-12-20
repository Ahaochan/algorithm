package 剑指offer.递归和循环;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 解题思路：
 * 同跳台阶类似
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... +f(1) + f(0)
 *
 * 动态规划一下
 * for(i->=n)
 *  for(j->i)
 *    dp[i] += dp[j]
 *
 * 如果用数学公式推导
 * f(n)   = f(n-1) + f(n-2) + f(n-3) + ... +f(1) + f(0)
 * f(n-1) =          f(n-2) + f(n-3) + ... +f(1) + f(0)
 * 合并两式, 得 f(n) = f(n-1) + f(n-1) = 2 * f(n-1), 为等比数列, 公比为2
 * f(n) = f(1) * 2^(n-1) = 2^(n-1)
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 变态跳台阶 {
    public static void main(String[] args) {
        变态跳台阶 main = new 变态跳台阶();

        for(int i = 0; i < 10; i++) {
            System.out.print(main.JumpFloorII(i) + " ");
        }
    }

    public int JumpFloorII(int target) {
        // 公式法
//        return (int) Math.pow(2, target - 1);

        // 动规法
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 1);

        for(int i = 2; i <= target; i++) {
            for(int j = 1; j < i; j++) {
                // f(n) = f(n-1) + f(n-2) + f(n-3) + ... +f(1) + f(0)
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
