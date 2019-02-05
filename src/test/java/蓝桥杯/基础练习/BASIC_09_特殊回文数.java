package 蓝桥杯.基础练习;

import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T48
 * @author Ahaochan
 * 问题描述
　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
输入格式
　　输入一行，包含一个正整数n。
输出格式
　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
样例输入
52
样例输出
899998
989989
998899
数据规模和约定
　　1<=n<=54。
 */
public class BASIC_09_特殊回文数 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 11111; i <= 999999; i++) {
			int a = i/100000, b = i%100000/10000, c = i%10000/1000,
				d = i%1000/100, e = i%100/10, f = i%10;
			if(a+b+c+d+e+f == n) {
				// 6位数 和 5位数 的情况
				if((a!=0 && a==f && b==e && c==d) || (a==0 && b==f && c==e)) {
					System.out.println(i);
				}
			}	
		}
	}
}
