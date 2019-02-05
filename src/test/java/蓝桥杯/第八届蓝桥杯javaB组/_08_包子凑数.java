package 蓝桥杯.第八届蓝桥杯javaB组;

import java.util.Scanner;

public class _08_包子凑数 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int min = 99999999;
		boolean[] mark = new boolean[10000];
		for(int i = 0 ;i < a.length; i++){
			a[i] = in.nextInt();
			mark[a[i]] = true;
			if(min>a[i]) min = a[i];
		}
		
		int flag = 0;
		int none = 0;
		for(int i = 1; i < mark.length && flag<min; i++){
			if(i<min){
				none++;
				continue;
			}
			for(int j = 0; j < a.length && !mark[i]; j++){
				if(i-a[j]>0)	mark[i] = mark[i-a[j]];
			}
			if(mark[i]){
				flag++;
			} else {
				none++;
				flag = 0;
			}
		}
		if(flag>=min){
			System.out.println(none);
		} else {
			System.out.println("INF");
		}
	}
}

/**
 * 小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。每种> 蒸笼都有非常多笼，可以认为是无限笼。
每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。比如一共有> 3种蒸笼，分别能放3、4和5个包子。当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个> 的再加2笼4个的）。
当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。而顾客想买7个> 包子时，大叔就凑不出来了。
小明想知道一共有多少种数目是包子大叔凑不出来的。
输入
第一行包含一个整数N。(1 <= N <= 100)
以下N行每行包含一个整数Ai。(1 <= Ai <= 100)
输出
一个整数代表答案。如果凑不出的数目有无限多个，输出INF。
例如，
输入：
2
4
5
。 。 。 4 5 。 。 8 9 10 。 12 13 14 15
程序应该输出：
6

再例如，
输入：
2
4
6

程序应该输出：
INF

样例解释：
对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。
对于样例2，所有奇数都凑不出来，所以有无限多个。
*/
