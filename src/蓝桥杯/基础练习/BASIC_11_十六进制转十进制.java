package 蓝桥杯.基础练习;

import java.util.*;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T50
 * @author Ahaochan
 * 问题描述
　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
样例输入
FFFF
样例输出
65535
 */
public class BASIC_11_十六进制转十进制 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		System.out.println(Long.parseLong(in.next(), 16));
		char[] hex = in.next().toCharArray();
		long num = 0;
		for(int i = 0; i < hex.length; i++){
			num += hex2dec(hex[i])*Math.pow(16, hex.length-i-1);
		}
		System.out.println(num);
	}
	
	public static int hex2dec(char dec){
		int num = 0;
		switch(dec){
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':num=dec-'0';break;
			case 'a':
			case 'A':num=10;break;
			case 'b':
			case 'B':num=11;break;
			case 'c':
			case 'C':num=12;break;
			case 'd':
			case 'D':num=13;break;
			case 'e':
			case 'E':num=14;break;
			case 'f':
			case 'F':num=15;break;
		}
		return num;
	}
}
