package 算法爱好者;

import java.util.Scanner;

/**
 * 
 * @author Ahaochan
 * 题目描述
输入一个字符串，求出该字符串包含的字符集合
输入描述:
每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
输出描述:
每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
输入例子:
abcqweracb
输出例子:
abcqwer
 */
public class 华为_字符集合 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		String str = in.next();
		boolean[] bucket = new boolean['z'+1];
		for(int i = 0, len = str.length(); i < len; i++){
			char ch = str.charAt(i);
			if(!bucket[ch]){
				bucket[ch] = true;
				System.out.print(ch);
			}
		}
		
	}
}