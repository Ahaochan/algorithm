package 蓝桥杯.基础练习;

import java.util.*;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T56
 * @author Ahaochan
 * 问题描述
　　给定两个仅由大写字母或小写字母组成的字符串(长度介于1到10之间)，它们之间的关系是以下4中情况之一：
　　1：两个字符串长度不等。比如 Beijing 和 Hebei
　　2：两个字符串不仅长度相等，而且相应位置上的字符完全一致(区分大小写)，比如 Beijing 和 Beijing
　　3：两个字符串长度相等，相应位置上的字符仅在不区分大小写的前提下才能达到完全一致（也就是说，它并不满足情况2）。比如 beijing 和 BEIjing
　　4：两个字符串长度相等，但是即使是不区分大小写也不能使这两个字符串一致。比如 Beijing 和 Nanjing
　　编程判断输入的两个字符串之间的关系属于这四类中的哪一类，给出所属的类的编号。
输入格式
　　包括两行，每行都是一个字符串
输出格式
　　仅有一个数字，表明这两个字符串的关系编号
样例输入
BEIjing
beiJing 
样例输出
3
 */
public class BASIC_15_字符串对比 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] str1 = in.next().toCharArray(), str2 = in.next().toCharArray();
		if(str1.length!=str2.length){
			System.out.println(1);
		}else if(equals(str1, str2, true)){
			System.out.println(2);
		}else if(equals(str1, str2, false)){
			System.out.println(3);
		}else {
			System.out.println(4);
		}
	}
	
	/**
	 * 
	 * @param str1 字符串1
	 * @param str2 字符串2
	 * @param isCase 是否匹配大小写
	 * @return 
	 */
	public static boolean equals(char[] str1, char[] str2, boolean isCase){
		boolean flag = true;
		if(str1.length!=str2.length) return false;

		for(int i = 0; i < str1.length && flag; i++){
			if(!isCase){
				str1[i] = (char) (str1[i]>=97?str1[i]-32:str1[i]);
				str2[i] = (char) (str2[i]>=97?str2[i]-32:str2[i]);
			}
			
			flag = str1[i]==str2[i];
		}
		return flag;
	}
}
