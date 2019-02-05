package LeetCode;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 题目描述:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 解题思路
 * 斐波那契, 假设 f(n) 为爬到第 n 阶的方法数.
 * f(1) = 1
 * f(2) = f(1) + 1    // f(1) 再爬一层 和 f(0)再爬两层
 * f(3) = f(2) + f(1) // f(2) 再爬一层 和 f(1)再爬两层
 * f(4) = f(3) + f(2) // f(3) 再爬一层 和 f(2)再爬两层
 * 得到
 * f(n) = f(n-2) + f(n-1)
 *
 */
public class _0070_爬楼梯 {
    public static void main(String[] args) {
        _0070_爬楼梯 main = new _0070_爬楼梯();
        System.out.println(main.climbStairs(2)); // 2
        System.out.println(main.climbStairs(3)); // 3
    }

    public int climbStairs(int n) {
        // 1. 少于 2 阶的情况
        if(n <= 2) return n;

        // 2. 斐波那契
        int a = 1, b = 1;
        while (n-- >= 2) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
