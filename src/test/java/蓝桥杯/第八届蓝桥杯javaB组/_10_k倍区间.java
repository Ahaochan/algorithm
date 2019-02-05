package 蓝桥杯.第八届蓝桥杯javaB组;

import java.util.Scanner;

public class _10_k倍区间 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt();
		int[] a = new int[n];
		int[][] matrix = new int[n][n];
		int sum = 0;
		for(int i = 0; i < a.length; i++ ){
			a[i] = in.nextInt();
			matrix[i][i] = a[i];
			if(matrix[i][i]%k==0) sum++;
		}
		
		
		for(int i = 0 ; i < n ; i++){
			for(int j = i+1; j < n; j++){
				matrix[i][j] = matrix[i][j-1]+a[j];
				if(matrix[i][j]%k==0) sum++;
			}
		}
		System.out.println(sum);
	}
	
}
/**
给定一个长度为N的数列，A1, A2, ... AN，如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <= j)之和是K的倍数，我们就称这个区间[i, j]是K倍区间。  

你能求出数列中总共有多少个K倍区间吗？  

输入
-----
第一行包含两个整数N和K。(1 <= N, K <= 100000)  
以下N行每行包含一个整数Ai。(1 <= Ai <= 100000)  

输出
-----
输出一个整数，代表K倍区间的数目。  


例如，
输入：
5 2
1  
2  
3  
4  
5  

程序应该输出：
6

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms
*/