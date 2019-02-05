package LintCode;

import java.util.Scanner;

/**
 * https://www.lintcode.com/zh-cn/problem/lowercase-to-uppercase/
 * 145. 大小写转换
 * 描述
 * 将一个字符由小写字母转换为大写字母
 * 样例
 * a -> A
 * b -> B
 */
public class _145大小写转换 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char c = in.next().charAt(0);
        System.out.println(lowercaseToUppercase(c));
    }

    public static char lowercaseToUppercase(char character) {
        return (char) (character - 32);
    }
}
