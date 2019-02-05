package 蓝桥杯.基础练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T57
 * @author Ahaochan
 * 问题描述
　　求出区间[a,b]中所有整数的质因数分解。
输入格式
　　输入两个整数a，b。
输出格式
　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
样例输入
3 10
样例输出
3=3
4=2*2
5=5
6=2*3
7=7
8=2*2*2
9=3*3
10=2*5
提示
　　先筛出所有素数，然后再分解。
数据规模和约定
　　2<=a<=b<=10000

 */
public class BASIC_16_分解质因数 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt(), b = in.nextInt();
		boolean[] primes = new boolean[b+1];
		String[] result = new String[b+1];
		Arrays.fill(primes, true);
		
		// 求质数, 装入list
		for(int i = 2, len = primes.length; i < len; i++){
			if(primes[i]){
				for(int j = i+i; j < len; j+=i){
					primes[j] = false;
				}
			}
		}
		List<Integer> list = new ArrayList<>(primes.length);
		for(int i = 2, len = primes.length; i < len; i++){
			if(primes[i]){
				result[i] = i+"";
				list.add(i);
			}
		}
		
		// 动态规划
		for(int i = 2, plen = list.size(); i <= b; i++){
			int idx = plen-1;
			int num = list.get(idx);
			// i未被分解质因数则循环
			while(result[i]==null){
				// i被num整除, 则在必有某个数*num得到i
				if(i%num==0){
					// 状态转移方程
					result[i] = result[i/num]+"*"+num;
				} else {
					// 从大到小取所有质数进行试除
					idx--;
					num = list.get(idx);
				}
			}
		}
		
		for(int i = a; i <= b; i++){
			System.out.println(i+"="+result[i]);
		}

	}
}
