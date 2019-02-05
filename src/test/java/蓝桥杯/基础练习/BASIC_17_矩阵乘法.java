package 蓝桥杯.基础练习;

import java.util.Scanner;


/**
 * http://lx.lanqiao.cn/problem.page?gpid=T58
 * @author Ahaochan
 * 问题描述
　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
　　例如：
　　A =
　　1 2
　　3 4
　　A的2次幂
　　7 10
　　15 22
输入格式
　　第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
　　接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
输出格式
　　输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
样例输入
2 2
1 2
3 4
样例输出
7 10
15 22

 */
public class BASIC_17_矩阵乘法 {
	private static long[][][] arr;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		arr = new long[m>=2?m+1:2][][];
		arr[0] = new long[n][n]; // 矩阵的0次方
		arr[1] = new long[n][n]; // 矩阵的1次方
		for(int i = 0; i < n; i++){
			arr[0][i][i] = 1;
			for(int j = 0; j < n; j++){
				arr[1][i][j] = in.nextInt();
			}
		}
		
		arr[m] = dfs(m);
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(arr[m][i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static long[][] dfs(int deep){
		if(deep==0) return arr[0];
		if(deep==1) return arr[1];
		
		 // 矩阵的deep/2次方
		if(arr[deep/2]==null){
			arr[deep/2] = dfs(deep/2);
		}
		
		// 矩阵快速幂
		// m^5 = m*m*m*m*m, 5次运算
		// m^5 = (m*m)*(m*m)*m, 3次运算, 先算m*m, 再算m^2*m^2, 最后算m^4*m
		long[][] result = mul(arr[deep/2], arr[deep/2]);
		if(deep%2!=0){
			result = mul(result, arr[1]);
		}
		return result;
	}
	
	// 矩阵乘法
	public static long[][] mul(long[][] m1, long[][] m2){
		long[][] result = new long[m1.length][m2[0].length];
		for(int i=0;i<m1.length;i++) {
            for(int j=0;j<m2[0].length;j++) {
                for(int k=0;k<m2.length;k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
		return result;
	}
}
