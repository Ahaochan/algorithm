package LintCode;

import java.util.Scanner;

/**
 * https://www.lintcode.com/zh-cn/problem/reverse-3-digit-integer/
 * 37. 反转一个3位整数
 * 描述
 * 反转一个只有3位数的整数。
 * 样例
 * 123 反转之后是 321。
 * 900 反转之后是 9。
 */
public class _37反转一个3位整数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(reverseInteger(n));
    }

    public static int reverseInteger(int number) {
        int hundred = number / 100;
        int ten = (number - hundred * 100) / 10;
        int one = number % 10;

        return one*100+ten*10+hundred;
    }
}
