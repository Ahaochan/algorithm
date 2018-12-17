package 剑指offer.递归和循环;

/**
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 解题思路：
 * 斐波那契是经典的递归题目, 也可以作为动规题做
 * 有公式如下
 * f(0) = 0                 n = 0
 * f(1) = 1                 n = 1
 * f(n) = f(n-1) + f(n-2)   n > 1
 *
 * 如果是多次求斐波那契数列第n项, 最好是缓存到一个数组里, 避免重复计算
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        斐波那契数列 main = new 斐波那契数列();

        for(int i = 0; i < 10; i++) {
            System.out.print(main.Fibonacci(i) + " ");
        }
    }

    public int Fibonacci(int n) {
        int a0 = 0, a1 = 1;
        // for(int i = 0; i < n; i++) {
        while(n-- > 0) {
            a0 = a0 + a1;
            a1 = a0 - a1;
            // 缓存 Fibonacci[i] = a0
        }
        return a0;
    }
}
