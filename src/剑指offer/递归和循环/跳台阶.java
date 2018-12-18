package 剑指offer.递归和循环;

/**
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 解题思路：
 * 斐波那契的应用
 * 函数f(n)表示第n阶有f(n)种跳法, 对于第n阶, 只有第n-1阶再跳一级, 加上第n-2阶再跳两级, 即f(n-1)+f(n-2)种跳法
 * f(0) = 0                     n = 0
 * f(1) = 1                     n = 1
 * f(2) = 2 = f(1) + f(0)       n = 2
 * f(3) = 3 = f(2) + f(1)       n = 3
 * f(n) = f(n-1) + f(n-2)       n > 1
 *
 * 如果是多次求斐波那契数列第n项, 最好是缓存到一个数组里, 避免重复计算
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 跳台阶 {
    public static void main(String[] args) {
        跳台阶 main = new 跳台阶();

        for(int i = 0; i < 10; i++) {
            System.out.print(main.JumpFloor(i) + " ");
        }
    }

    public int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }

        int a = 1, b = 1;
        for(int i = 2; i <= target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
