package 蓝桥杯.算法训练;

import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T13
 * @author Ahaochan
 * 问题描述
如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。由于这个数目很大，请你输出它对1000000007取模后的值。
输入格式
输入包含两个正整数，K和L。
输出格式
输出一个整数，表示答案对1000000007取模后的值。
样例输入
4 2
样例输出
7
数据规模与约定
对于30%的数据，KL <= 106；
对于50%的数据，K <= 16， L <= 10；
对于100%的数据，1 <= K,L <= 100。
 */
public class ALGO_3_K好数 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt(), l = in.nextInt();
		int mod = 1000000007;
		int[][] dp = new int[l+2][k];
		for(int j = 0; j < k; j++){
			dp[1][j] = 1;
		}
		
		// 比如k=4, l=2, k好数有11,13,20,22,30,31,33 
		// 当首位为1时, 10和12不是k好数, 因为0和2相邻1, k好数只有11, 13 
		// 当首位为2时, 21和23不是k好数, 因为1和3相邻2, k好数只有20, 22 
		// 当首位为3时, 23不是k好数, 因为3相邻2, k好数只有30,31,33
		
		// dp[i][j]表示长度为i且首位为j的数字, 有多少种情况
		// 动态转移方程dp[i][j] += dp[i-1][0..k(排除j+1和j-1)]
		for(int i = 2; i <= l; i++){
			for(int j = 0; j < k; j++){
				for(int num = 0; num < k; num++){
					if(num!=j-1 && num!=j+1){
						dp[i][j] += dp[i-1][num];
						dp[i][j] %= mod;
					}
				}
			}
		}
		
		int sum = 0;
		for(int i = 1; i < k; i++){
			sum += dp[l][i];
			sum %= mod;
		}
		System.out.println(sum);
	}
}
