package 蓝桥杯.基础练习;

import java.util.*;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T8
 * @author Ahaochan
 * 问题描述
给出n个数，找出这n个数的最大值，最小值，和。
输入格式
第一行为整数n，表示数的个数。
第二行有n个数，为给定的n个数，每个数的绝对值都小于10000。
输出格式
输出三行，每行一个整数。第一行表示这些数中的最大值，第二行表示这些数中的最小值，第三行表示这些数的和。
样例输入
5
1 3 -2 4 5
样例输出
5
-2
11
数据规模与约定
1 <= n <= 10000。
 */
public class BASIC_04_数列特征 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int min = 99999;
		int max = -9999;
		long sum = 0;
		for(int i = 0; i < n; i++){
			int num = in.nextInt();
			// 比最小值小, 覆盖min
			if(num<min){
				min = num;
			}
			// 比最大值大, 覆盖max
			if(num>max){
				max = num;
			}
			// 求和
			sum += num;
		}
		System.out.println(max+"\n"+min+"\n"+sum);
	}
}
