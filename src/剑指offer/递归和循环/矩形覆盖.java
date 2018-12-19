package 剑指offer.递归和循环;

/**
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 *
 * 解题思路：
 * 也是斐波那契的应用
 * 用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有 f(n) 种方法
 * 假设这是一个矩形
 * _ _ _ _ _
 * _ _ _ _ _
 *
 * 当 f(1) 时, 只能容纳一个 1*2 的矩形, 只有一种方法
 * _                                    1
 * _                                    1
 * 当 f(2) 时, 只能容纳容纳 1*2并排, 或者 2*1 并排的两个矩形, 有两种方法
 * _ _                    1 2            1 1
 * _ _                    1 2            2 2
 * 当 f(3) 时, 先填上一个 1*2 的矩形, 那剩下的只有 f(2) 种, 再换成 2*1 的情况, 那就只剩下 f(1) 种方法
 * 1 _ _                                                 1 1 _
 * 1 _ _                                                 2 2 _
 * 当 f(n) 时, 先填上一个 1*2 的矩形, 那剩下的只有 f(n-1) 种, 再换成 2*1 的情况, 那就只剩下 f(n-2) 种方法
 * 1 _ _ _ _ _                                           1 1 _ _ _ _
 * 1 _ _ _ _ _                                           2 2 _ _ _ _
 *
 * 可以得到表达式
 * f(1) = 1                   n = 1
 * f(2) = 2                   n = 2
 * f(n) = f(n-1) + f(n-2)     n > 2
 * 一个斐波那契数列
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 矩形覆盖 {

    public static void main(String[] args) {
        矩形覆盖 main = new 矩形覆盖();

        for(int i = 0; i < 10; i++) {
            System.out.print(main.RectCover(i) + " ");
        }
    }

    public int RectCover(int target) {
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
