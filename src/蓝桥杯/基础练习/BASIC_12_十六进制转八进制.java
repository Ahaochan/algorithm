package 蓝桥杯.基础练习;

import java.util.*;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T51
 * @author Ahaochan
 * 问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。
输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
输出格式
　　输出n行，每行为输入对应的八进制正整数。
　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。
样例输入
　　2
　　39
　　123ABC
样例输出
　　71
　　4435274
　　【提示】
　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。
 */
public class BASIC_12_十六进制转八进制 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n-->0){
			char[] hex = in.next().toCharArray();
			StringBuilder bin = new StringBuilder(hex.length*4);
			// 先转2进制
			for(int i = 0; i < hex.length; i++) {
				switch(hex[i]) {
					case '0':bin.append("0000");break;
					case '1':bin.append("0001");break;
					case '2':bin.append("0010");break;
					case '3':bin.append("0011");break;
					case '4':bin.append("0100");break;
					case '5':bin.append("0101");break;
					case '6':bin.append("0110");break;
					case '7':bin.append("0111");break;
					case '8':bin.append("1000");break;
					case '9':bin.append("1001");break;
					case 'a':
					case 'A':bin.append("1010");break;
					case 'b':
					case 'B':bin.append("1011");break;
					case 'c':
					case 'C':bin.append("1100");break;
					case 'd':
					case 'D':bin.append("1101");break;
					case 'e':
					case 'E':bin.append("1110");break;
					case 'f':
					case 'F':bin.append("1111");break;
				}
			}
			
			// 补0
			switch(bin.length()%3) {
				case 1:bin.insert(0, "00");break;
				case 2:bin.insert(0, "0");break;
			}
			
			boolean first = true;
			StringBuilder oct = new StringBuilder(bin.length()/3);
			int binLength = bin.length();
			// 转8进制
			for(int i = 0; i < binLength; i+=3){
				switch(bin.substring(i,i+3)){
					case "000":if(!first)oct.append("0");break;
					case "001":oct.append("1");first = false;break;
					case "010":oct.append("2");first = false;break;
					case "011":oct.append("3");first = false;break;
					case "100":oct.append("4");first = false;break;
					case "101":oct.append("5");first = false;break;
					case "110":oct.append("6");first = false;break;
					case "111":oct.append("7");first = false;break;
				}
			}
			System.out.println(oct.toString());
		}
	}
}
