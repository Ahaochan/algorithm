package 蓝桥杯.基础练习;

import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T63
 * @author Ahaochan
 * 问题描述
　　FJ在沙盘上写了这样一些字符串：
　　A1 = “A”
　　A2 = “ABA”
　　A3 = “ABACABA”
　　A4 = “ABACABADABACABA”
　　… …
　　你能找出其中的规律并写所有的数列AN吗？
输入格式
　　仅有一个数：N ≤ 26。
输出格式
　　请输出相应的字符串AN，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
样例输入
3
样例输出
ABACABA
 */
public class BASIC_22_FJ的字符串 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(fj(n));
	}
	
	public static String fj(int n){
		return n==1?"A":fj(n-1)+((char) ('A'+n-1))+fj(n-1);
	}
}
