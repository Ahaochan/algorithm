package 蓝桥杯.基础练习;

import java.util.*;

/** 
 * http://lx.lanqiao.cn/problem.page?gpid=T60
 * @author Ahaochan
 * 问题描述
　　回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
　　交换的定义是：交换两个相邻的字符
　　例如mamad
　　第一次交换 ad : mamda
　　第二次交换 md : madma
　　第三次交换 ma : madam (回文！完美！)
输入格式
　　第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
　　第二行是一个字符串，长度为N.只包含小写字母
输出格式
　　如果可能，输出最少的交换次数。
　　否则输出Impossible
样例输入
5
mamad
样例输出
3

 */
public class BASIC_19_完美的代价 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] str = in.next().toCharArray();
		
		// 判断是否构成回文串
		boolean[] flag = new boolean['z'-'a'+1];
		for(int i = 0, len = str.length; i < len; i++){
			flag[str[i]-'a'] = !flag[str[i]-'a'];
		}
		for(int i = 0, len = flag.length, count = 0; i < len; i++){
			if(flag[i]) {
				count++;
			}
			if(count>1){
				System.out.println("Impossible");
				return;
			}
		}
		
		
		int count = 0;
		for(int i = 0, len = str.length-1; i < len/2; i++){// 从左往右扫描待匹配的字符
			boolean find = false;
			for(int j = len-i; j > i && !find; j--){// 从右往左扫描，找到对应的字符
				if(str[i]==str[j]){
					find = true;
					for(int k = j; k < len-i; k++){// 慢慢交换位置，直到到达对应位置
						count++;
						char temp = str[k+1];
						str[k+1] = str[k];
						str[k] = temp;
					}
				}
			}
			// 如果是aba型回文串，即未找到对应的字符，则将其往后移动一位，贪心策略
			// 不可直接将其移动至中间, 会有bug
			if(!find){
				count++;
				char temp = str[i+1];
				str[i+1] = str[i];
				str[i] = temp;
				i--;
			}
		}
		System.out.println(count);
	}
}
