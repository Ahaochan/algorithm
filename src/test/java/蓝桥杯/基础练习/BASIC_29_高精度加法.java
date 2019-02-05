package 蓝桥杯.基础练习;

import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T70
 * @author Ahaochan
 * 问题描述
　　输入两个整数a和b，输出这两个整数的和。a和b都不超过100位。
算法描述
　　由于a和b都比较大，所以不能直接使用语言中的标准数据类型来存储。对于这种问题，一般使用数组来处理。
　　定义一个数组A，A[0]用于存储a的个位，A[1]用于存储a的十位，依此类推。同样可以用一个数组B来存储b。
　　计算c = a + b的时候，首先将A[0]与B[0]相加，如果有进位产生，则把进位（即和的十位数）存入r，把和的个位数存入C[0]，即C[0]等于(A[0]+B[0])%10。然后计算A[1]与B[1]相加，这时还应将低位进上来的值r也加起来，即C[1]应该是A[1]、B[1]和r三个数的和．如果又有进位产生，则仍可将新的进位存入到r中，和的个位存到C[1]中。依此类推，即可求出C的所有位。
　　最后将C输出即可。
输入格式
　　输入包括两行，第一行为一个非负整数a，第二行为一个非负整数b。两个整数都不超过100位，两数的最高位都不是0。
输出格式
　　输出一行，表示a + b的值。
样例输入
20100122201001221234567890
2010012220100122
样例输出
20100122203011233454668012
 */
public class BASIC_29_高精度加法 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String aStr = in.next();
		String bStr = in.next();
		int len = Math.max(aStr.length(), bStr.length());
		int[] a = new int[len+1]; // 多1位进位
		int[] b = new int[len+1]; // 多1位进位
		int[] c = new int[len+1]; // 多1位进位
		for(int i = len, j = aStr.length()-1; i >= 0 && j >= 0; i--, j--){
			a[i] = aStr.charAt(j)-'0';
		}
		for(int i = len, j = bStr.length()-1; i >= 0 && j >= 0; i--, j--){
			b[i] = bStr.charAt(j)-'0';
		}
		
		long start1 = System.currentTimeMillis();
		for(int i = len; i >= 0; i--){
			c[i] += a[i]+b[i];
			// 进位
			if(c[i]>=10){
				c[i-1] += c[i]/10;
				c[i] %= 10;
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.println((end1-start1));
		
		// 去除头部的0
		int idx = 0;
		for(int i = idx, l = c.length; i < l; i++){
			if(c[i]!=0){
				idx = i;
				break;
			}
		}
		for(int i = idx, l = c.length; i < l; i++){
			System.out.print(c[i]);
		}
		
		long start2 = System.currentTimeMillis();
		int num = 99999999+99999999;
		long end2 = System.currentTimeMillis();
		System.out.println((end2-start2));
	}
}
