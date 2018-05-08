package 蓝桥杯.基础练习;

import java.util.*;

/**
 * http://blog.csdn.net/u011506951/article/details/26442861
 * @author Ahaochan
 * 问题描述
　　Tom教授正在给研究生讲授一门关于基因的课程，有一件事情让他颇为头疼：一条染色体上有成千上万个碱基对，它们从0开始编号，到几百万，几千万，甚至上亿。
　　比如说，在对学生讲解第1234567009号位置上的碱基时，光看着数字是很难准确的念出来的。
　　所以，他迫切地需要一个系统，然后当他输入12 3456 7009时，会给出相应的念法：
　　十二亿三千四百五十六万七千零九
　　用汉语拼音表示为
　　shi er yi san qian si bai wu shi liu wan qi qian ling jiu
　　这样他只需要照着念就可以了。
　　你的任务是帮他设计这样一个系统：给定一个阿拉伯数字串，你帮他按照中文读写的规范转为汉语拼音字串，相邻的两个音节用一个空格符格开。
　　注意必须严格按照规范，比如说“10010”读作“yi wan ling yi shi”而不是“yi wan ling shi”，“100000”读作“shi wan”而不是“yi shi wan”，“2000”读作“er qian”而不是“liang qian”。
输入格式
　　有一个数字串，数值大小不超过2,000,000,000。
输出格式
　　是一个由小写英文字母，逗号和空格组成的字符串，表示该数的英文读法。
样例输入
1234567009
样例输出
shi er yi san qian si bai wu shi liu wan qi qian ling jiu
 */
public class BASIC_20_数的读法 {
	
	private static String[] NUM = {"ling ", "yi ", "er ", "san ", "si ","wu ","liu ","qi ","ba ","jiu "};
	private static String[] UNIT = {"", "", "wan ", "yi "};  
	private static String[] DIGIT = { "", "", "shi ", "bai ", "qian " };  
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] num = in.next().toCharArray();
		StringBuilder sb = new StringBuilder();
		int len = num.length;
		int idx = 0;
		
		int group = (len-1)/4+1;
		int rest = len%4;
		
		if(rest!=0){
			if(rest==2){
				if(num[idx]!='1'){
					sb.append(NUM[num[idx]-'0']);
				}
				sb.append(DIGIT[2]);
				idx++;
				
				if(num[idx]!='0'){
					sb.append(NUM[num[idx]-'0']);
				}
				idx++;
			} else {
				boolean zero = false;
				for(int i = rest; i > 0; i--){
					char ch = num[idx++];
					if(ch!='0'){
						if(zero){
							sb.append(NUM[0]);
						}
						sb.append(NUM[ch-'0']+DIGIT[i]);
					} else {
						zero = true;
					}
				}
			}
			sb.append(UNIT[group--]);  
		}
		
		for (int i = group; i > 0; i--) {  
			boolean zero = false;
            for (int j = 4; j > 0; j--) {  
                char ch = num[idx++];  
                
                if(ch!='0'){
					if(zero){
						sb.append(NUM[0]);
						zero = false;
					}
					sb.append(NUM[ch-'0']+DIGIT[j]);
				} else {
					zero = true;
				}
            }  
            sb.append(UNIT[group--]);
        }  
		
		System.out.println(sb);
	}
}
