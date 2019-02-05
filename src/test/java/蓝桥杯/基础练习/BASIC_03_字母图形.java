package 蓝桥杯.基础练习;

import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T7
 * @author Ahaochan
 * 问题描述
利用字母可以组成一些美丽的图形，下面给出了一个例子：
ABCDEFG
BABCDEF
CBABCDE
DCBABCD
EDCBABC
这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
输入格式
输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
输出格式
输出n行，每个m个字符，为你的图形。
样例输入
5 7
样例输出
ABCDEFG
BABCDEF
CBABCDE
DCBABCD
EDCBABC
数据规模与约定
1 <= n, m <= 26。
 */
public class BASIC_03_字母图形 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		// 每行字母总数固定为m
		// 第i行(从0开始)的第1个字母是A之后第i个字母
		for(int i = 0; i < n; i++){
			// 输出字母总数num
			int num = 0;
			// 输出[X,A)区间的字母, X为A之后第i个字母
			for(char j = (char) ('A'+i); j > 'A' && num<m; j--){
				num++;
				System.out.print(j);
			}
			// 输出[A, Y]区间的字母, Y为字母总数限定的字母
			for(char j = 'A'; j < 'A'-i+m ;j++){
				System.out.print(j);
			}
			System.out.println("");
		}
	}
}
