package 蓝桥杯.基础练习;

import java.util.*;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T49
 * @author Ahaochan
 * 问题描述
　　十六进制数是在程序设计时经常要使用到的一种整数的表示方式。它有0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F共16个符号，分别表示十进制数的0至15。十六进制的计数方法是满16进1，所以十进制数16在十六进制中是10，而十进制的17在十六进制中是11，以此类推，十进制的30在十六进制中是1E。
　　给出一个非负整数，将它表示成十六进制的形式。
输入格式
　　输入包含一个非负整数a，表示要转换的数。0<=a<=2147483647
输出格式
　　输出这个整数的16进制表示
样例输入
30
样例输出
1E
 */
public class BASIC_10_十进制转十六进制 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int dec = in.nextInt();
		StringBuilder hex = new StringBuilder();
		// 短除法
		while(dec/16>0){
			hex.insert(0, dec2hex(dec%16));
			dec /= 16;
		}
		hex.insert(0, dec2hex(dec));
		System.out.println(hex.toString());

	}
	
	// 十进制转十六进制
	public static char dec2hex(int dec){
		char hex = '0';
		switch(dec){
			case 10: hex = 'A';break;
			case 11:hex='B';break;
			case 12:hex='C';break;
			case 13:hex='D';break;
			case 14:hex='E';break;
			case 15:hex='F';break;
			default: hex = (char) (dec+'0');
		}
		return hex;
	}
}
