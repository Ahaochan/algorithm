package LintCode;

import java.util.Scanner;

/**
 * https://www.lintcode.com/problem/fibonacci/description
 * 366. 斐波纳契数列
 * 描述
 * 查找斐波纳契数列中第 N 个数。
 * 所谓的斐波纳契数列是指：
 * 前2个数是 0 和 1 。
 * 第 i 个数是第 i-1 个数和第i-2 个数的和。
 * 斐波纳契数列的前10个数字是：
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * 样例
 * 给定 1，返回 0
 * 给定 2，返回 1
 * 给定 10，返回 34
 */
public class _366斐波纳契数列 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
//        1. 递归超时
//        if(n <= 1) return 0;
//        if(n == 2) return 1;
//        return fibonacci(n-1)+fibonacci(n-2);

        // 2. for循环
        int[] arr = new int[n];
        if(n>0) arr[0] = 0;
        if(n>1) arr[1] = 1;
        for(int i = 2; i < n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n-1];
    }
}
