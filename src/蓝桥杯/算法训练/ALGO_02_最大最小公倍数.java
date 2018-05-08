package 蓝桥杯.算法训练;

import java.util.*;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T12(后台数据有bug)
 * @author Ahaochan
 * 问题描述
已知一个正整数N，问从1~N中任选出三个数，他们的最小公倍数最大可以为多少。
输入格式
输入一个正整数N。
输出格式
输出一个整数，表示你找到的最小公倍数。
样例输入
9
样例输出
504
数据规模与约定
1 <= N <= 106。
 */
public class ALGO_02_最大最小公倍数 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long result;
		// 相邻的两个数互质
		if(n <= 2) {  
			result = n;
        } else if(n%2==1){
        	// n为奇数时, 只有n-1是偶数, 没有公因子2,
        	// 若n-2有公因子3, 则下一个3的倍数是n+1, 所以也没有公因子3
        	// 同理得到n*(n-1)*(n-2)两两互质
        	result = n*(n-1)*(n-2);
		} else {
			 if(n%3==0){
				// n为偶数时, 有n和n-2是偶数, 有公因子2, 
				// 后移一位, 求 n*(n-1)*(n-3);
				// 当n-3是有公因子3的时候, n也有公因子3
				// 将n=n-1, 套用偶数的情况
				result= (n-1)*(n-2)*(n-3);
			 } else {
				// n为偶数时, 有n和n-2是偶数, 有公因子2, 
				// 后移一位, 求 n*(n-1)*(n-3);
				result = n*(n-1)*(n-3);  
			 }
//			result = (n-1)*(n-2)*(n-3);
		}
		System.out.println(result);
	}
}
